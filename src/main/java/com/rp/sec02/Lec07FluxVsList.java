package com.rp.sec02;

import com.rp.courseutil.Util;
import com.rp.sec02.helper.NameGenerator;

public class Lec07FluxVsList {
  public static void main(String[] args) {
    NameGenerator.getNames(5)
            .forEach(System.out::println);
    NameGenerator.getFluxNames(5)
            .subscribe(Util.onNext());
  }
}
