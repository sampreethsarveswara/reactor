package com.rp.sec02;

import com.rp.courseutil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {
  public static void main(String[] args) {

    AtomicReference<Subscription> atomicReference = new AtomicReference<>();

    Flux.range(3, 10)
            .log()
            .subscribeWith(new Subscriber<Integer>() {
              @Override
              public void onSubscribe(Subscription subscription) {
                System.out.println("Received Subscription: "+subscription);
                atomicReference.set(subscription);
              }

              @Override
              public void onNext(Integer integer) {
                System.out.println("onNext: "+ integer);
              }

              @Override
              public void onError(Throwable throwable) {
                System.out.println("onError: "+ throwable.getMessage());
              }

              @Override
              public void onComplete() {
                System.out.println("onComplete");
              }
            });

    Util.sleepSecond(3);
    atomicReference.get().request(3);
    Util.sleepSecond(5);
    atomicReference.get().request(4);
    Util.sleepSecond(5);
    atomicReference.get().cancel();
    Util.sleepSecond(5);
    atomicReference.get().request(3);
  }
}
