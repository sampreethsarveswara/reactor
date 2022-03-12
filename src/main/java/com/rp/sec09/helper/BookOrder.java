package com.rp.sec09.helper;

import com.rp.courseutil.Util;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BookOrder {
  private String title;
  private String author;
  private String category;
  private double price;

  public BookOrder() {
    this.title = Util.faker().book().title();
    this.author = Util.faker().book().author();
    this.category = Util.faker().book().genre();
    this.price = Double.parseDouble(Util.faker().commerce().price());
  }
}
