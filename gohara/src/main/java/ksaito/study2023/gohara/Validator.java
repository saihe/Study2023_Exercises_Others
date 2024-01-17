package ksaito.study2023.gohara;

import java.util.regex.Pattern;

public class Validator {
  public static boolean integer(String src) {
    return Pattern.matches("^[0-9]{1,8}$", src);
  }
}
