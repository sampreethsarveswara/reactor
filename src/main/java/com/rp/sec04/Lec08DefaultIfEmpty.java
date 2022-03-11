package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec08DefaultIfEmpty {
  public static void main(String[] args) {
    getOrderedNumbers()
            .filter(i -> i>10)
            .defaultIfEmpty(-100)
            .subscribe(Util.subscriber());
  }

  private static Flux<Integer> getOrderedNumbers() {
    return Flux.range(1, 10);
  }
}
