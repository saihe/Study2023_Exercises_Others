package ksaito.study2023.nakamaki.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Fortunes {
  Highest("大吉"),
  Higher("中吉"),
  High("吉"),
  Normal("末吉"),
  Low("凶"),
  Lowest("大凶");

  private final String displayName;

  /**
   * キーが1/2/3のいずれかの場合はHighest、
   * 4/5のいずれかの場合はHigher、
   * 6の場合はHigh、7の場合はLow、8の場合はLowest、それ以外の場合はNormalを返す。
   * @param key キー
   * @return .
   */
  public static Fortunes switchByIntKey(int key) {
    return switch (key) {
      case 1, 2, 3 -> Highest;
      case 4, 5 -> Higher;
      case 6 -> High;
      case 7 -> Low;
      case 8 -> Lowest;
      default -> Normal;
    };
  }
}
