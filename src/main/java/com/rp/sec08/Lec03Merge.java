package com.rp.sec08;

import com.rp.courseutil.Util;
import com.rp.sec08.helper.AirIndia;
import com.rp.sec08.helper.Indigo;
import com.rp.sec08.helper.SpiceJet;
import reactor.core.publisher.Flux;

public class Lec03Merge {
  public static void main(String[] args) {
    Flux<String> flux = Flux.merge(
            Indigo.getFlights(),
            AirIndia.getFlights(),
            SpiceJet.getFlights()
    );
    flux.subscribe(Util.subscriber());
    Util.sleepSecond(10);
  }
}
