package ksaito.study2023.gohara.infrastructure.store;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import ksaito.study2023.gohara.domain.model.Category;
import ksaito.study2023.gohara.domain.model.Dish;
import ksaito.study2023.gohara.domain.model.Taste;
import ksaito.study2023.gohara.domain.model.Type;
import ksaito.study2023.gohara.domain.repository.DishRepository;

public class DishRepositoryImpl implements DishRepository {
  private final Dish[] dataStore;

  public DishRepositoryImpl() {
    dataStore = new Dish[]{
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

  @Override
  public List<Dish> search(Category category, Type type, Taste taste) {
    return Arrays.stream(dataStore)
      .filter(d -> Objects.isNull(category) || d.categories().contains(category))
      .filter(d -> Objects.isNull(type) || d.types().contains(type))
      .filter(d -> Objects.isNull(taste) || d.tastes().contains(taste))
      .toList();
  }
}
