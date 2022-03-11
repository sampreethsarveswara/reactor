package com.rp.sec04;

import com.rp.courseutil.Util;
import com.rp.sec04.helper.Person;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lec11SwitchOnFirst {

  public static void main(String[] args) {
    getPersons()
            .switchOnFirst((signal, personFlux) -> {
              return signal.isOnNext() && signal.get().getAge() > 10 ? personFlux : applyFiler().apply(personFlux);
            })
            .subscribe(Util.subscriber());
  }

  private static Flux<Person> getPersons() {
    return Flux.range(1, 10)
            .map(i -> new Person());
  }

  private static Function<Flux<Person>, Flux<Person>> applyFiler() {
    return personFlux -> personFlux
            .filter(person -> person.getAge() > 10)
            .doOnNext(person -> person.setName(person.getName().toUpperCase()))
            .doOnDiscard(Person.class, person -> System.out.println("discarded: " + person));
  }
}
