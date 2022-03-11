package com.rp.sec02;

import com.rp.courseutil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec05FluxRange {
  public static void main(String[] args) {
    Flux.range(3, 10)
            .log()
            .map(i -> Util.faker().name().fullName())
            .log()
            .subscribe(Util.onNext());

  }
}
