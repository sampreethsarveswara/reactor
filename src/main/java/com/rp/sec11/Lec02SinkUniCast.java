package com.rp.sec11;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec02SinkUniCast {
  public static void main(String[] args) {

    Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

    Flux<Object> flux = sink.asFlux();

    flux.subscribe(Util.subscriber("Sam"));

    // will not work, only one subscriber because UniCast
    flux.subscribe(Util.subscriber("mike"));

    for (int i = 0; i < 5; i++) {
      sink.tryEmitNext(i);
    }
    sink.tryEmitComplete();
  }
}
