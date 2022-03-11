package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {
  public static void main(String[] args) {
    Mono<String> mono = Mono.just("a");
    Flux<String> flux = Flux.from(mono);
    test(flux);

    Flux.range(1,10)
            .filter(i -> i>3)
            .next()
            .subscribe(Util.onNext());
  }

  private static void test(Flux input) {
    input.subscribe(Util.onNext());
  }
}
