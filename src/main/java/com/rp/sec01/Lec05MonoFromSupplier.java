package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {
  public static void main(String args[]) {
    // Use Just Method only when you already have data, otherwise it will call method, which is not behaviour of publisher
//    Mono<String> mono = Mono.just(getName());

    Mono<String> mono = Mono.fromSupplier(() -> getName());
    mono.subscribe(
            Util.onNext()
    );
//
//    Supplier<String> stringSupplier = () -> getName();
//    Mono<String> mono = Mono.fromSupplier(stringSupplier);
//    mono.subscribe(
//            Util.onNext()
//    );
//
//    Callable<String> stringCallable = () -> getName();
//    Mono.fromCallable(stringCallable)
//            .subscribe(
//                    Util.onNext()
//            );
  }

  private static String getName() {
    System.out.println("Generating Name");
    return Util.faker().name().fullName();
  }
}
