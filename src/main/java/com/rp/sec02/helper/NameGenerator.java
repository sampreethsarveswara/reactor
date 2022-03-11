package com.rp.sec02.helper;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

  public static List<String> getNames(int count) {
    List<String> strings = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      strings.add(getName());
    }
    return strings;
  }

  public static Flux<String> getFluxNames(int count) {
    return Flux.range(1, count)
            .map(i -> getName());
  }

  private static String getName() {
    Util.sleepSecond(1);
    return Util.faker().name().fullName();
  }
}
