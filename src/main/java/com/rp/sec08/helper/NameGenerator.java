package com.rp.sec08.helper;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

  private List<String> list = new ArrayList<>();

  public Flux<String> generateNames() {
    return Flux.generate(stringSynchronousSink -> {
      System.out.println("Generate Fresh");
      Util.sleepMillis(1);
      String name = Util.faker().name().fullName();
      list.add(name);
      stringSynchronousSink.next(name);
    })
            .cast(String.class)
            .startWith(getCacheNames());
  }

  public Flux<String> getCacheNames() {
    return Flux.fromIterable(list);
  }
}
