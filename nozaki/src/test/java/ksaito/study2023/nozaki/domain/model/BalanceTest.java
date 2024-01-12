package ksaito.study2023.nozaki.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTest {

  @Test
  void totalAmount() {
    assertEquals(1000, new Balance("2000", "1000").totalAmount().intValue());
  }
}
