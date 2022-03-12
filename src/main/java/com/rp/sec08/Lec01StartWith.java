package com.rp.sec08;

import com.rp.courseutil.Util;
import com.rp.sec08.helper.NameGenerator;

public class Lec01StartWith {
  public static void main(String[] args) {
    NameGenerator nameGenerator = new NameGenerator();
    nameGenerator.generateNames()
            .take(2)
            .subscribe(Util.subscriber("sam"));

    nameGenerator.generateNames()
            .take(2)
            .subscribe(Util.subscriber("mike"));

    nameGenerator.generateNames()
            .take(3)
            .subscribe(Util.subscriber("joe"));

    nameGenerator.generateNames()
            .filter(name -> name.startsWith("A"))
            .take(3)
            .subscribe(Util.subscriber("kali"));
  }
}
