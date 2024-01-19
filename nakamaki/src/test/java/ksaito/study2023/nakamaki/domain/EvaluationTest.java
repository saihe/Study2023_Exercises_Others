package ksaito.study2023.nakamaki.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EvaluationTest {
  @Nested
  class SwitchByTimeMillis {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void Good(int param) {
      assertEquals(Evaluation.Good, Evaluation.switchByIntKey(param));
    }
    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    void Bad(int param) {
      assertEquals(Evaluation.Bad, Evaluation.switchByIntKey(param));
    }
    @ParameterizedTest
    @ValueSource(ints = {6, 7, 8, 9, 0})
    void Normal(int param) {
      assertEquals(Evaluation.Normal, Evaluation.switchByIntKey(param));
    }
  }
}
