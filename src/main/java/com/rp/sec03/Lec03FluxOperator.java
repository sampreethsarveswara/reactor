package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxOperator {
  public static void main(String[] args) {
    Flux.range(1,10)
            .log()
            .take(4) // After 4 items, cancel subscription for above
            .log()
            .subscribe(Util.subscriber());
  }
}
