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
  @Override
  public List<Dish> search(Category category, Type type, Taste taste) {
    return Arrays.stream(DataStore.dataStore)
      .filter(d -> Objects.isNull(category) || d.categories().contains(category))
      .filter(d -> Objects.isNull(type) || d.types().contains(type))
      .filter(d -> Objects.isNull(taste) || d.tastes().contains(taste))
      .toList();
  }
}
