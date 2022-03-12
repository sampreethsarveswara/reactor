package com.rp.sec09;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec05Group {
  public static void main(String[] args) {

    Flux.range(1,30)
            .delayElements(Duration.ofSeconds(1))
            .groupBy(num -> num%2)
            .subscribe(groupFlex -> process(groupFlex, groupFlex.key()));

    Util.sleepSecond(60);
  }

  private static void process(Flux<Integer> flux, int key) {
    System.out.println("Process");
    flux.subscribe(i -> System.out.println("Key: " +  key + ", Item: " + i));
  }
}
