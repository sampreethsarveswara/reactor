package com.rp.sec07;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lec02Drop {
  public static void main(String[] args) {

    // 75% filled remove queue and next 12 (after value)
    System.setProperty("reactor.bufferSize.small", "16");

    List<Object> droppedValues = new ArrayList<>();


    Flux.create(fluxSink -> {
              for (int i = 0; i < 501; i++) {
                fluxSink.next(i);
                System.out.println("Pushed: "+i);
                Util.sleepMillis(1);
              }
              fluxSink.complete();
            })
            .onBackpressureDrop(droppedValues::add)
            .publishOn(Schedulers.boundedElastic())
            .doOnNext(i -> {
              Util.sleepMillis(10);
            })
            .subscribe(Util.subscriber());

    Util.sleepSecond(60);
  }
}

