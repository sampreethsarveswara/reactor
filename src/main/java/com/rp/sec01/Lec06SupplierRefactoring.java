package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {
  public static void main(String args[]) {
    getName();
    String name = getName()
            .subscribeOn(Schedulers.boundedElastic())
            .block();
    System.out.println(name);
    getName()
            .subscribeOn(Schedulers.boundedElastic())
            .subscribe(
                    Util.onNext()
            );
    getName();

    Util.sleepSecond(4);
  }

  private static Mono<String> getName() {
    System.out.println("getName");
    return Mono.fromSupplier(() -> {
      System.out.println("Generating Name");
      Util.sleepSecond(3);
      return Util.faker().name().fullName();
    }).map(String::toUpperCase);
  }
}
