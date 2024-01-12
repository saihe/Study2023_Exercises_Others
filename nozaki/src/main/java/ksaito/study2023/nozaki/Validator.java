package ksaito.study2023.nozaki;

import java.util.regex.Pattern;

public class Validator {
  private static final String DecimalFormat = "^-?[0-9]+$";

  /**
   * 金額バリデーション.
   * @param val .
   * @return .
   */
  static boolean decimal(String val) {
    return Pattern.matches(DecimalFormat, val);
  }
}
