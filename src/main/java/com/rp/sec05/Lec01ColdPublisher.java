package com.rp.sec05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec01ColdPublisher {
  public static void main(String[] args) {
    Flux<String> movieFlux = Flux.fromStream(() -> getMovie())
            .delayElements(Duration.ofSeconds(2));
    movieFlux.subscribe(Util.subscriber("sam"));
    Util.sleepSecond(5);
    movieFlux.subscribe(Util.subscriber("mike"));
    Util.sleepSecond(60);

  }

  private static Stream<String> getMovie() {
    return Stream.of(
            "Scene 1",
            "Scene 2",
            "Scene 3",
            "Scene 4",
            "Scene 5",
            "Scene 6",
            "Scene 7",
            "Scene 8"
    );
  }
}
