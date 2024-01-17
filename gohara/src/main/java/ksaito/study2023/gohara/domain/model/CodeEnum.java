package ksaito.study2023.gohara.domain.model;

import java.util.Arrays;

public interface CodeEnum<E extends Enum<E>> {
  int getIndex();

  @SuppressWarnings("unchecked")
  static <E extends Enum<E>> E getByIndex(Class<? extends CodeEnum<E>> clazz, int index) {
    return Arrays.stream(clazz.getEnumConstants())
      .filter(e -> e.getIndex() == index)
      .map(e -> (E) e)
      .findFirst()
      .orElse(null);  }
}
