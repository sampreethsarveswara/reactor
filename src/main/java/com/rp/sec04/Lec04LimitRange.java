package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04LimitRange {
  public static void main(String[] args) {
    Flux.range(1,1000)
            .log()
            .limitRate(100, 90)
            .subscribe(Util.subscriber());
  }
}
