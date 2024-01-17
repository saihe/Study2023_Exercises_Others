package ksaito.study2023.gohara;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

  @Nested
  class Integer {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "99999999"})
    void valid(String src) {
      assertTrue(Validator.integer(src));
    }
    @ParameterizedTest
    @ValueSource(strings = {"", "-", "a", "あ", "１", "0.1", "123456789"})
    void invalid(String src) {
      assertFalse(Validator.integer(src));
    }
  }
}
