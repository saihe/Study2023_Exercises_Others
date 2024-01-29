package ksaito.study2023.gohara.infrastructure.store;

import ksaito.study2023.gohara.domain.model.Category;
import ksaito.study2023.gohara.domain.model.Dish;
import ksaito.study2023.gohara.domain.model.Taste;
import ksaito.study2023.gohara.domain.model.Type;

import java.util.List;

public class DataStore {
  static Dish[] dataStore;

  public static void migrate(Dish[] dataStore) {
    DataStore.dataStore = dataStore;
  }

  public static Dish[] sampleData() {
    return new Dish[]{
      new Dish(
        "おにぎり",
        List.of(Category.Japanese),
        List.of(Type.Rice),
        List.of(Taste.Salty)
      ),
      new Dish(
        "ラーメン",
        List.of(Category.Japanese),
        List.of(Type.Noodles),
        List.of(Taste.Salty)
      ),
      new Dish(
        "ゴーヤチャンプル",
        List.of(Category.Japanese),
        List.of(Type.None),
        List.of(Taste.Salty)
      ),
      new Dish(
        "ペペロンチーノ",
        List.of(Category.Italian),
        List.of(Type.Noodles),
        List.of(Taste.Salty, Taste.Hard)
      ),
      new Dish(
        "マルゲリータ",
        List.of(Category.Italian),
        List.of(Type.Bread),
        List.of(Taste.Salty)
      ),
      new Dish(
        "デザートピザ",
        List.of(Category.Italian),
        List.of(Type.Bread),
        List.of(Taste.Sweet)
      ),
      new Dish(
        "フレンチトースト",
        List.of(Category.French),
        List.of(Type.Bread),
        List.of(Taste.Sweet)
      )
    };
  }
}
