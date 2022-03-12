package com.rp.sec12.helper;

import reactor.util.context.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class UserService {
  private static final Map<String, String> MAP = new HashMap<>();

  static {
    MAP.put("sam", "std");
    MAP.put("mike", "prime");
  }

  public static Function<Context, Context> userCategoryContext() {
    return ctx -> {
      String user = ctx.get("user").toString();
      String category = MAP.get(user);
      return ctx.put("category", category);
    };
  }

}
