package com.rp.sec06;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec03SubscribeOnMultipleItems {
  public static void main(String[] args) {
    Flux<Object> flux = Flux.create(fluxSink -> {
              printThreadName("create");
              for (int i = 0; i < 20; i++) {
                fluxSink.next(i);
              }
            })
            .doOnNext(i -> printThreadName("next " + i));

    flux
            .subscribeOn(Schedulers.boundedElastic()) // Use in real case, otherwise we are blocking main thread ** imp
            .subscribe(v -> printThreadName("sub " + v));

    Util.sleepSecond(5);
  }

  private static void printThreadName(String msg) {
    System.out.println(msg + "\t\t: Thread : " + Thread.currentThread());
  }
}