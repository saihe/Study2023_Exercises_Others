package ksaito.study2023.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AppException extends Exception {
  private int code;
  public AppException(Throwable t) {
    super(t);
    this.code = 1;
  }
  public AppException(String message, Throwable t) {
    super(message, t);
    this.code = 1;
  }

  public AppException(String message) {
    super(message);
    this.code = 1;
  }
}
