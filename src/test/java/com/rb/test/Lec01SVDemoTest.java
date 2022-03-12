package com.rb.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec01SVDemoTest {

  @Test
  public void test1() {
    Flux<Integer> flux = Flux.just(1,2,3);
    StepVerifier.create(flux)
            .expectNext(1)
            .expectNext(2)
            .expectNext(3)
            .verifyComplete();
  }

  @Test
  public void test2() {
    Flux<Integer> flux = Flux.just(1,2,3);
    StepVerifier.create(flux)
            .expectNext(1,2,3)
            .verifyComplete();
  }
}
