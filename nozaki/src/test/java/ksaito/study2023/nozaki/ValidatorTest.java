package ksaito.study2023.nozaki;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

  @Nested
  class Decimal {
    @ParameterizedTest
    @ValueSource(strings = {"1000", "-1000"})
    void valid(String val) {
      assertTrue(Validator.decimal(val));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "+"})
    void invalid(String val) {
      assertFalse(Validator.decimal(val));
    }
  }
}
