package com.rp.sec02.assignment;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class StockPriceSubscriber {
  public static void main(String[] args) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(1);

    StockPrice.getPrice()
            .subscribeWith(new Subscriber<Integer>() {

              private Subscription subscription;

              @Override
              public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                this.subscription.request(Long.MAX_VALUE);
              }

              @Override
              public void onNext(Integer price) {
                System.out.println(LocalDateTime.now() + " : price : " + price);
                if (price > 110 || price < 90) {
                  this.subscription.cancel();
                  latch.countDown();
                }
              }

              @Override
              public void onError(Throwable throwable) {
                latch.countDown();
              }

              @Override
              public void onComplete() {
                latch.countDown();
              }
            });
    latch.await();
  }
}
