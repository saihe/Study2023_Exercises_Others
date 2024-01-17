package ksaito.study2023.gohara.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Taste implements CodeEnum<Taste> {
  Sweet(0, "甘い"),
  Hard(1, "辛い"),
  Salty(2, "しょっぱい"),
  Bitter(3, "苦い");

  private final int index;
  private final String name;

  public String toString() {
    return String.format("%d：%s", index, name);
  }
}
