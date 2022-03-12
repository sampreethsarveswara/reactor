package com.rp.sec09;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec02OverLap {
  public static void main(String[] args) {
    eventStream()
            .buffer(3, 1)
            .subscribe(Util.subscriber());
    Util.sleepSecond(20);
  }

  private static Flux<String> eventStream() {
    return Flux.interval(Duration.ofMillis(300))
            .map(i -> "event "+i);
  }
}
