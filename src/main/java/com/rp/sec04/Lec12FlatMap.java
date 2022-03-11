package com.rp.sec04;

import com.rp.courseutil.Util;
import com.rp.sec04.helper.OrderService;
import com.rp.sec04.helper.UserService;

public class Lec12FlatMap {
  public static void main(String[] args) {
    UserService.getUser()
//            .map(user -> OrderService.getOrders(user.getUserId()))
            .flatMap(user -> OrderService.getOrders(user.getUserId())) // two pipelines -> random from both // use concatMap to complete first and go for next
            .subscribe(Util.subscriber());
  }
}
