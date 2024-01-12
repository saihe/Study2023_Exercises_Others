package ksaito.study2023.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AppException extends Exception {
  private int code;
  public AppException(Throwable t) {
    super(t);
    this.code = 0;
  }
  public AppException(String message, Throwable t) {
    super(message, t);
    this.code = 0;
  }
}
