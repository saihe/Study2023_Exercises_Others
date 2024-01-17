package ksaito.study2023.gohara.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Type implements CodeEnum<Type> {
  None(0, "分類なし"),
  Rice(1, "米"),
  Noodles(2, "麺"),
  Bread(3, "パン"),
  Sweets(4, "お菓子"),
  Fried(5, "揚げ物");

  private final int index;
  private final String name;

  public String toString() {
    return String.format("%d：%s", index, name);
  }
}
