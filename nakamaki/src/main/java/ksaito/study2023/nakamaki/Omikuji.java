package ksaito.study2023.nakamaki;

import ksaito.study2023.common.AppException;
import ksaito.study2023.common.Application;
import ksaito.study2023.nakamaki.domain.Evaluation;
import ksaito.study2023.nakamaki.domain.Fortunes;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * おみくじアプリ.
 */
public class Omikuji implements Application {
  @Override
  public void run(String[] args) throws AppException {
    System.out.println("おみくじ！");
    System.out.printf("運勢：%s%n", Fortunes.switchByTimeMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)).getDisplayName());
    System.out.printf("願い事：%s%n", Evaluation.switchByTimeMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)).getDisplayName());
    System.out.printf("待ち人：%s%n", Evaluation.switchByTimeMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)).getDisplayName());
    System.out.printf("失し物：%s%n", Evaluation.switchByTimeMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)).getDisplayName());
    System.out.printf("旅行：%s%n", Evaluation.switchByTimeMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)).getDisplayName());
    System.out.printf("ビジネス：%s%n", Evaluation.switchByTimeMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)).getDisplayName());
    System.out.printf("学問：%s%n", Evaluation.switchByTimeMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)).getDisplayName());
    System.out.printf("争い事：%s%n", Evaluation.switchByTimeMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)).getDisplayName());
    System.out.printf("恋愛：%s%n", Evaluation.switchByTimeMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)).getDisplayName());
    System.out.printf("縁談：%s%n", Evaluation.switchByTimeMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)).getDisplayName());
    System.out.printf("転居：%s%n", Evaluation.switchByTimeMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)).getDisplayName());
    System.out.printf("病気：%s%n", Evaluation.switchByTimeMillis(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)).getDisplayName());
  }
}