package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec09SwitchIfEmpty {
  public static void main(String[] args) {
    getOrderedNumbers()
            .filter(i -> i>10)
            .switchIfEmpty(fallback())
            .subscribe(Util.subscriber());
  }

  // redis cache
  private static Flux<Integer> getOrderedNumbers() {
    return Flux.range(1, 10);
  }

  // db
  private static Flux<Integer> fallback() {
    return Flux.range(20,30);
  }
}
