package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01Handle {
  public static void main(String[] args) {
    // Handle = filter + map
    Flux.range(1, 20)
            .handle((input, synchronousSink) -> {
              if (input==7) {
                synchronousSink.complete();
              } else {
                synchronousSink.next(input);
              }
            })
            .subscribe(Util.subscriber());
  }
}
