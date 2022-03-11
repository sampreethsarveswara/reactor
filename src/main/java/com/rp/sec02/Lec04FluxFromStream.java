package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1,2,3);
    Stream<Integer> stream = list.stream();

//    stream.forEach(System.out::println); //closed - already processed  - next error
//    stream.forEach(System.out::println);
    Flux<Integer> integerFlux = Flux.fromStream(stream);
    // use () -> list.stream()
    integerFlux.subscribe(
            Util.onNext(),
            Util.onError(),
            Util.onComplete()
    );
    integerFlux.subscribe(
            Util.onNext(),
            Util.onError(),
            Util.onComplete()
    );
  }
}
