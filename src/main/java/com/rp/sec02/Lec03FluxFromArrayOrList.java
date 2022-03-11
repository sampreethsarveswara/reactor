package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOrList {
  public static void main(String[] args) {
    List<String> strings = Arrays.asList("a", "b", "c");
    Flux.fromIterable(strings)
            .subscribe(Util.onNext());
    Integer[] integers = {1,3,4};
    Flux.fromArray(integers)
            .subscribe(Util.onNext());
  }
}
