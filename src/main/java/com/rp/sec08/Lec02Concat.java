package com.rp.sec08;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec02Concat {
  public static void main(String[] args) {
    Flux<String> flux1 = Flux.just("a", "b");
    Flux<String> flux2 = Flux.error(new RuntimeException("Noo"));
    Flux<String> flux3 = Flux.just("c", "d", "e");

    Flux<String> flux = Flux.concat(flux1, flux2, flux3);
    Flux<String> fluxDelayError = Flux.concatDelayError(flux1, flux2, flux3);

    flux.subscribe(Util.subscriber());
    fluxDelayError.subscribe(Util.subscriber());

  }
}
