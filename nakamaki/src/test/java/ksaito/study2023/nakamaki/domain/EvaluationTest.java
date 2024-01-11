package ksaito.study2023.nakamaki.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EvaluationTest {
  @Nested
  class SwitchByTimeMillis {
    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3})
    void Good(long param) {
      assertEquals(Evaluation.Good, Evaluation.switchByTimeMillis(param));
    }
    @ParameterizedTest
    @ValueSource(longs = {4, 5})
    void Bad(long param) {
      assertEquals(Evaluation.Bad, Evaluation.switchByTimeMillis(param));
    }
    @ParameterizedTest
    @ValueSource(longs = {6, 7, 8, 9, 0})
    void Normal(long param) {
      assertEquals(Evaluation.Normal, Evaluation.switchByTimeMillis(param));
    }
  }
}
