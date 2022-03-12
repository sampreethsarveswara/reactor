package com.rp.sec09;

import com.rp.courseutil.Util;
import com.rp.sec09.assignment.OrderProcessor;
import com.rp.sec09.assignment.OrderService;
import com.rp.sec09.assignment.PurchaseOrder;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Lec06Assignment {
  public static void main(String[] args) {

    Map<String, Function<Flux<PurchaseOrder>,Flux<PurchaseOrder>>> map = new HashMap<>();
    map.put("Kids", OrderProcessor.kidsProcess());
    map.put("Automotive", OrderProcessor.automotiveProcess());

    Set<String> keys = map.keySet();

    OrderService.orderStream()
            .filter(order -> keys.contains(order.getCategory()))
            .groupBy(PurchaseOrder::getCategory)
            .flatMap(groupFlex -> map.get(groupFlex.key()).apply(groupFlex))
            .subscribe(Util.subscriber());

    Util.sleepSecond(60);
  }
}
