package com.rp.sec09;

import com.rp.courseutil.Util;
import com.rp.sec09.helper.BookOrder;
import com.rp.sec09.helper.RevenueReport;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lec03Assignment {
  public static void main(String[] args) {
    Set<String> allowedCategories = new HashSet<>();
    allowedCategories.add("Science fiction");
    allowedCategories.add("Fantasy");
    allowedCategories.add("Suspense/Thriller");

    bookStream()
            .filter(book -> allowedCategories.contains(book.getCategory()))
            .buffer(Duration.ofSeconds(5))
            .map(list -> revenueCalculator(list))
            .subscribe(Util.subscriber());

    Util.sleepSecond(60);
  }

  private static RevenueReport revenueCalculator(List<BookOrder> bookOrders) {
    Map<String, Double> map =  bookOrders.stream()
            .collect(Collectors.groupingBy(
                    BookOrder::getCategory,
                    Collectors.summingDouble(BookOrder::getPrice)
            ));
    return new RevenueReport(map);
  }

  private static Flux<BookOrder> bookStream() {
    return Flux.interval(Duration.ofMillis(200))
            .map(i -> new BookOrder());
  }
}