package ksaito.study2023.nakamaki.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FortunesTest {
  @Nested
  class SwitchByTimeMillis {
    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3})
    void Highest(long param) {
      assertEquals(Fortunes.Highest, Fortunes.switchByTimeMillis(param));
    }
    @ParameterizedTest
    @ValueSource(longs = {4, 5})
    void Higher(long param) {
      assertEquals(Fortunes.Higher, Fortunes.switchByTimeMillis(param));
    }
    @Test
    void High() {
      assertEquals(Fortunes.High, Fortunes.switchByTimeMillis(6L));
    }
    @Test
    void Low() {
      assertEquals(Fortunes.Low, Fortunes.switchByTimeMillis(7L));
    }
    @Test
    void Lowest() {
      assertEquals(Fortunes.Lowest, Fortunes.switchByTimeMillis(8L));
    }
    @ParameterizedTest
    @ValueSource(longs = {9, 0})
    void Normal(long param) {
      assertEquals(Fortunes.Normal, Fortunes.switchByTimeMillis(param));
    }
  }
}
