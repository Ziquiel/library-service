package com.globallogic.library.service.functions;

import jakarta.annotation.Nonnull;

import java.util.function.Function;

public class CalcularMulta implements Function<Integer, Integer> {
  @Override public Integer apply(@Nonnull Integer diasDeAtraso) {
    if (diasDeAtraso == 0) {
      return 0;
    }
    if (diasDeAtraso > 0 && diasDeAtraso >= 7) {
      return diasDeAtraso * 10;
    } else {
      return diasDeAtraso * 20;
    }

  }
}
