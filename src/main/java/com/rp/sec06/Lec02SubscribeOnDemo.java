package com.rp.sec06;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02SubscribeOnDemo {
  public static void main(String[] args) {
    Flux<Object> flux = Flux.create(fluxSink -> {
              printThreadName("create");
              fluxSink.next(1);
            })
            .doOnNext(i -> printThreadName("next " + i));

    Runnable runnable = () -> flux
            .doFirst(() -> printThreadName("first2"))
            .subscribeOn(Schedulers.boundedElastic()) // Use in real case, otherwise we are blocking main thread ** imp
            .doFirst(() -> printThreadName("first1"))
            .subscribe(v -> printThreadName("sub " + v));

    for (int i = 0; i < 2; i++) {
      new Thread(runnable).start();
    }
    Util.sleepSecond(5);
  }

  private static void printThreadName(String msg) {
    System.out.println(msg + "\t\t: Thread : " + Thread.currentThread());
  }
}