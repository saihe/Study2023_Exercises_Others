package ksaito.study2023.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AppException extends Exception {
  private int code;
}
