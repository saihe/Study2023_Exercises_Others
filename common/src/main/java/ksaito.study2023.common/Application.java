package ksaito.study2023.common;

import ksaito.study2023.common.exception.AppException;

public interface Application {
  void run(String[] args) throws AppException;
}
