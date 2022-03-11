package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
  public static void main(String args[]) {

    //Publisher
    Mono<Integer> mono = Mono.just("ball")
                            .map(String::length)
                            .map(l -> l/0);

    //Subscriber
//    mono.subscribe(
//            item -> System.out.println(item),
//            err -> System.out.println(err.getMessage()),
//            () -> System.out.println("Completed")
//    );

    mono.subscribe(
            Util.onNext(),
            Util.onError(),
            Util.onComplete()
    );
  }
}
