package com.rb.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec02SVErrorTest {
  @Test
  public void test2() {
    Flux<Integer> flux = Flux.just(1,2,3);
    Flux<Object> fluxError = Flux.error(new RuntimeException("err"));
    Flux<Object> concat = Flux.concat(flux, fluxError);
    StepVerifier.create(concat)
            .expectNext(1,2,3)
            .verifyError();
  }

  @Test
  public void test3() {
    Flux<Integer> flux = Flux.just(1,2,3);
    Flux<Object> fluxError = Flux.error(new RuntimeException("err"));
    Flux<Object> concat = Flux.concat(flux, fluxError);
    StepVerifier.create(concat)
            .expectNext(1,2,3)
            .verifyError(RuntimeException.class);
  }

  @Test
  public void test4() {
    Flux<Integer> flux = Flux.just(1,2,3);
    Flux<Object> fluxError = Flux.error(new RuntimeException("err"));
    Flux<Object> concat = Flux.concat(flux, fluxError);
    StepVerifier.create(concat)
            .expectNext(1,2,3)
            .verifyErrorMessage("err");
  }
}
