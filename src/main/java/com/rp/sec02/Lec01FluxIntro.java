package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec01FluxIntro {
  public static void main(String[] args) {
    Flux<Object> flux = Flux.just(1,2,3,"a", Util.faker().name().firstName());
    flux.subscribe(
            Util.onNext(),
            Util.onError(),
            Util.onComplete()
    );
  }
}
