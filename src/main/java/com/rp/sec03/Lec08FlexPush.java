package com.rp.sec03;

import com.rp.courseutil.Util;
import com.rp.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec08FlexPush {
  public static void main(String[] args) {
    NameProducer nameProducer = new NameProducer();

    // Push is not thread safe
    // Use only for single thread
    Flux.push(nameProducer)
            .subscribe(Util.subscriber());

    Runnable runnable = nameProducer::produce;

    for (int i = 0; i < 10; i++) {
      new Thread(runnable).start();
    }

    Util.sleepSecond(3);
  }
}
