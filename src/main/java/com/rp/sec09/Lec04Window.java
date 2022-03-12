package com.rp.sec09;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec04Window {

  private static AtomicInteger atomicInteger = new AtomicInteger(1);

  public static void main(String[] args) {
    // Can Also mention time in window
    eventStream()
            .window(5)
            .flatMap(flex -> saveEvents(flex))
            .subscribe(Util.subscriber());
    Util.sleepSecond(20);
  }

  private static Flux<java.lang.String> eventStream() {
    return Flux.interval(Duration.ofMillis(300))
            .map(i -> "event "+i);
  }

  private static Mono<Integer > saveEvents(Flux<String> flux) {
    return flux
            .doOnNext(e -> System.out.println("saving " + e))
            .doOnComplete(() -> System.out.println("Flux Completed"))
            .then(Mono.just(atomicInteger.getAndIncrement()));
  }
}
