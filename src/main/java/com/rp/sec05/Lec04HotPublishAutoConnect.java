package com.rp.sec05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec04HotPublishAutoConnect {
  public static void main(String[] args) {
    // Share = publish().refCount(1)
    Flux<String> movieFlux = Flux.fromStream(() -> getMovie())
            .delayElements(Duration.ofSeconds(2))
            .publish()
            .autoConnect(1); // start if we have 1 subscriber
    // mike will not miss anything now
    // with in the time of first subscriber, second subscriber not joined, it will work as cold publisher
    movieFlux.subscribe(Util.subscriber("sam"));
    Util.sleepSecond(5);

    // Mike is about to join
    // Even if mike joins now, he can not watch due to autoconnet
    movieFlux.subscribe(Util.subscriber("mike"));
    Util.sleepSecond(60);

  }

  private static Stream<String> getMovie() {
    System.out.println("Streaming Movie Request");
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
