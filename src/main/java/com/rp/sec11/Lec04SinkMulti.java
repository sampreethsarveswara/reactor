package com.rp.sec11;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec04SinkMulti {
  public static void main(String[] args) {

    Sinks.Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();

    Flux<Object> flux = sink.asFlux();

    sink.tryEmitNext("hi");
    sink.tryEmitNext("how are you");

    flux.subscribe(Util.subscriber("Sam"));
    flux.subscribe(Util.subscriber("mike"));
    sink.tryEmitNext("?");
    flux.subscribe(Util.subscriber("kali"));
    sink.tryEmitNext("new mes");

    // Disable History - clear buffer before
    // Sinks.many().multicast().directAllOrNothing();
  }
}
