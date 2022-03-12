package com.rb.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec03RangeTest {
  @Test
  public void test2() {
    Flux<Integer> flux = Flux.range(1,50);
    StepVerifier.create(flux)
            .expectNextCount(50)
            .verifyComplete();
  }

  @Test
  public void test3() {
    Flux<Integer> flux = Flux.range(1,50);
    StepVerifier.create(flux)
            .thenConsumeWhile(i -> i <100)
            .verifyComplete();
  }
}
