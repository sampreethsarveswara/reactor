package com.rp.sec08;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04Zip {
  public static void main(String[] args) {
    Flux.zip(getBody(), getEngine(), getTires())
            .subscribe(Util.subscriber());
  }

  private static Flux<String> getEngine() {
    return Flux.range(1,2)
            .map(engine -> "engine");
  }

  private static Flux<String> getBody() {
    return Flux.range(1,5)
            .map(body -> "body");
  }

  private static Flux<String> getTires() {
    return Flux.range(1,8)
            .map(tire -> "tire");
  }
}
