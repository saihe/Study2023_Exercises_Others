package ksaito.study2023.murata.infrastructure.memory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import ksaito.study2023.murata.domain.model.Subscription;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubscriptionRepositoryImplTest {
  private SubscriptionRepositoryImpl target;

  @BeforeEach
  void setUp() {
    target = new SubscriptionRepositoryImpl();
  }

  @Test
  void saveAndList() {
    var expected = List.of(
      new Subscription("データ1", 1000, ""),
      new Subscription("データ2", 1000, "")
    );
    target.save(expected.get(0));
    target.save(expected.get(1));
    var actual = target.list();
    assertIterableEquals(expected, actual);
  }
}