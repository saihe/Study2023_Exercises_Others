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
    @ValueSource(ints = {1, 2, 3})
    void Highest(int param) {
      assertEquals(Fortunes.Highest, Fortunes.switchByIntKey(param));
    }
    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    void Higher(int param) {
      assertEquals(Fortunes.Higher, Fortunes.switchByIntKey(param));
    }
    @Test
    void High() {
      assertEquals(Fortunes.High, Fortunes.switchByIntKey(6));
    }
    @Test
    void Low() {
      assertEquals(Fortunes.Low, Fortunes.switchByIntKey(7));
    }
    @Test
    void Lowest() {
      assertEquals(Fortunes.Lowest, Fortunes.switchByIntKey(8));
    }
    @ParameterizedTest
    @ValueSource(ints = {9, 0})
    void Normal(int param) {
      assertEquals(Fortunes.Normal, Fortunes.switchByIntKey(param));
    }
  }
}
