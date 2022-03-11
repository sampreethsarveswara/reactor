package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {
  public static void main(String[] args) {
    Mono.fromRunnable(timeConsumingProcess())
            .subscribe(
                    Util.onNext(),
                    Util.onError(),
                    () -> {
                      System.out.println("Process Done, Send Emails");
                    }
            );
  }


  private static Runnable timeConsumingProcess() {
    return () -> {
      Util.sleepSecond(3);
      System.out.println("Operation Completed");
    };
  }

}
