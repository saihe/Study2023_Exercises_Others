package ksaito.study2023.gohara.domain.model;


import java.util.List;

/**
 * 料理.
 * @param name 名称
 * @param categories 和食などカテゴリ
 * @param types 米など種類
 * @param tastes 甘いなど味
 */
public record Dish(
  String name,
  List<Category> categories,
  List<Type> types,
  List<Taste> tastes
) {
  public Long containsCategoriesCount(List<Category> categories) {
    return categories.stream().filter(this.categories::contains).count();
  }
  public Long containsTypesCount(List<Type> types) {
    return types.stream().filter(this.types::contains).count();
  }
  public Long containsTastesCount(List<Taste> tastes) {
    return tastes.stream().filter(this.tastes::contains).count();
  }

  public Double precisionRate(List<Category> categories, List<Type> types, List<Taste> tastes) {
    return (
      containsCategoriesCount(categories).doubleValue()
        + containsTypesCount(types).doubleValue()
        + containsTastesCount(tastes).doubleValue()
    ) / (Category.values().length + Type.values().length + Taste.values().length)
    * 100;
  }
}
