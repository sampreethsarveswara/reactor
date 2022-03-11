package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec02HandleGenerate {
  public static void main(String[] args) {
    Flux.generate(synchronousSink -> {
      synchronousSink.next(Util.faker().country().name());
    })
            .map(Object::toString)
            .handle((s, synchronousSink) -> {
              synchronousSink.next(s);
              if (s.equalsIgnoreCase("canada")) {
                synchronousSink.complete();
              }
            })
            .subscribe(Util.subscriber());

  }
}
