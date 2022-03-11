package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec07Timeout {
  public static void main(String[] args) {
    getOrderedNumbers()
            .timeout(Duration.ofSeconds(2), fallback())
            .subscribe(Util.subscriber());
  }

  private static Flux<Integer> getOrderedNumbers() {
    return Flux.range(1,10)
            .delayElements(Duration.ofSeconds(5));
  }

  private static Flux<Integer> fallback() {
    return Flux.range(1,10)
            .delayElements(Duration.ofMillis(2));
  }

}
