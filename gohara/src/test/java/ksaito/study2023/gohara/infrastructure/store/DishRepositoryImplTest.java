package ksaito.study2023.gohara.infrastructure.store;

import ksaito.study2023.gohara.domain.model.Category;
import ksaito.study2023.gohara.domain.model.Taste;
import ksaito.study2023.gohara.domain.model.Type;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DishRepositoryImplTest {
  private final DishRepositoryImpl target = new DishRepositoryImpl();

  @BeforeAll
  static void init() {
    DataStore.migrate(DataStore.sampleData());
  }

  @Nested
  class Search {
    @Test
    void RiceBall() {
      assertEquals("おにぎり", target.search(Category.Japanese, Type.Rice, Taste.Salty).get(0).name());
    }

    @Test
    void Japanese() {
      assertEquals(3, target.search(Category.Japanese, null, null).size());
    }

    @Test
    void Noodles() {
      assertEquals(2, target.search(null, Type.Noodles, null).size());
    }

    @Test
    void Hard() {
      assertEquals(1, target.search(null, null, Taste.Hard).size());
    }
  }
}
