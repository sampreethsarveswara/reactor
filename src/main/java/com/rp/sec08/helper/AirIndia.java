package com.rp.sec08.helper;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class AirIndia {
  public static Flux<String> getFlights() {
    return Flux.range(1, Util.faker().random().nextInt(2,5))
            .delayElements(Duration.ofSeconds(1))
            .map(flight -> "AirIndia " + Util.faker().random().nextInt(200, 500))
            .filter(flight -> Util.faker().random().nextBoolean());
  }
}
