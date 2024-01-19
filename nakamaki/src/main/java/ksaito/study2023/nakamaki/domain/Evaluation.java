package ksaito.study2023.nakamaki.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Evaluation {
  Good("◎"),
  Normal("◯"),
  Bad("×");

  private final String displayName;

  /**
   * キーが1/2/3のいずれかの場合はGood、4/5のいずれかの場合はBad、それ以外はNormalを返す
   * @param key キー
   * @return .
   */
  public static Evaluation switchByIntKey(int key) {
    return switch (key) {
      case 1, 2, 3 -> Good;
      case 4, 5 -> Bad;
      default -> Normal;
    };
  }
}
