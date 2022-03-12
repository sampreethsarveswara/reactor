package com.rp.sec06;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec06Parallel {
  public static void main(String[] args) {
    // you can add thread number in parallel()
    Flux.range(1,10)
                    .parallel()
                    .runOn(Schedulers.parallel())
                    .doOnNext(i -> printThreadName("nest " + i))
                    .subscribe(s -> printThreadName("sub " + s));

    Util.sleepSecond(5);
  }

  private static void printThreadName(String msg) {
    System.out.println(msg + "\t\t: Thread : " + Thread.currentThread());
  }
}
