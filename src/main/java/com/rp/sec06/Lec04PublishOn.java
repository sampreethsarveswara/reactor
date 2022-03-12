package com.rp.sec06;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec04PublishOn {
  // Publish on -> for downstream

  public static void main(String[] args) {
    Flux<Object> flux = Flux.create(fluxSink -> {
              printThreadName("create");
              for (int i = 0; i < 4; i++) {
                fluxSink.next(i);
              }
            })
            .doOnNext(i -> printThreadName("next " + i));

    flux
            .publishOn(Schedulers.boundedElastic()) // Multiple thread pools async
            .doOnNext(i ->  printThreadName("next " + i))
//            .publishOn(Schedulers.parallel())
            .subscribe(v -> printThreadName("sub " + v));

    Util.sleepSecond(5);
  }

  private static void printThreadName(String msg) {
    System.out.println(msg + "\t\t: Thread : " + Thread.currentThread());
  }
}