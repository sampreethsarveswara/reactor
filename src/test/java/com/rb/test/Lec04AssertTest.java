package com.rb.test;

import com.rp.sec09.helper.BookOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Lec04AssertTest {
  @Test
  public void test2() {
    Mono<BookOrder> mono = Mono.fromSupplier(() -> new BookOrder());

    StepVerifier.create(mono)
            .assertNext(book -> Assertions.assertNotNull(book.getAuthor()))
            .verifyComplete();
  }

  @Test
  public void test3() {
    Mono<BookOrder> mono = Mono
            .fromSupplier(() -> new BookOrder())
            .delayElement(Duration.ofSeconds(2));

    StepVerifier.create(mono)
            .assertNext(book -> Assertions.assertNotNull(book.getAuthor()))
            .expectComplete()
            .verify(Duration.ofSeconds(3));
  }
}
