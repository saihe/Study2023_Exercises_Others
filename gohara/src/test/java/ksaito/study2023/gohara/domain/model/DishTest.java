package ksaito.study2023.gohara.domain.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DishTest {
  private final Dish target =
      new Dish("テスト", List.of(Category.values()), List.of(Type.values()), List.of(Taste.values()));

  @Test
  void containsCategoriesCount() {
    assertEquals(2, target.containsCategoriesCount(List.of(Category.Japanese, Category.Chinese)));
  }

  @Test
  void containsTypesCount() {
    assertEquals(2, target.containsTypesCount(List.of(Type.None, Type.Rice)));
  }

  @Test
  void containsTastesCount() {
    assertEquals(2, target.containsTastesCount(List.of(Taste.Sweet, Taste.Bitter)));
  }

  @Test
  void precisionRate() {
    assertEquals(20.0, target.precisionRate(
      List.of(Category.Japanese),
      List.of(Type.Noodles),
      List.of(Taste.Salty)
    ));
  }
}
