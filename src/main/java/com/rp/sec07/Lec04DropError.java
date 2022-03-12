package com.rp.sec07;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec04DropError {
  public static void main(String[] args) {

    // 75% filled remove queue and next 12 (after value)
    System.setProperty("reactor.bufferSize.small", "16");

    Flux.create(fluxSink -> {
              for (int i = 0; i < 501 && !fluxSink.isCancelled(); i++) {
                fluxSink.next(i);
                System.out.println("Pushed: "+i);
                Util.sleepMillis(1);
              }
              fluxSink.complete();
            })
            .onBackpressureError()
            .publishOn(Schedulers.boundedElastic())
            .doOnNext(i -> {
              Util.sleepMillis(10);
            })
            .subscribe(Util.subscriber());

    Util.sleepSecond(60);
  }
}