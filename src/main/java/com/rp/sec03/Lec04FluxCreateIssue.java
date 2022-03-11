package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssue {
  public static void main(String[] args) {

    Flux.create(fluxSink -> {
              int counter = 0;
              String country;
              do {
                country = Util.faker().country().name();
                fluxSink.next(country);
                counter++;
              } while (!country.equalsIgnoreCase("canada") && counter < 10);
              fluxSink.complete();
            })
            .log()
//            .take(3)
            .subscribe(Util.subscriber());
  }
}
