package ksaito.study2023.gohara.domain.repository;

import ksaito.study2023.gohara.domain.model.Category;
import ksaito.study2023.gohara.domain.model.Dish;
import ksaito.study2023.gohara.domain.model.Taste;
import ksaito.study2023.gohara.domain.model.Type;

import java.util.List;

public interface DishRepository {
  List<Dish> search(Category category, Type type, Taste taste);
}
