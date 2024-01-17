package ksaito.study2023.gohara;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import ksaito.study2023.common.Application;
import ksaito.study2023.common.exception.AppException;
import ksaito.study2023.gohara.domain.model.Category;
import ksaito.study2023.gohara.domain.model.CodeEnum;
import ksaito.study2023.gohara.domain.model.Dish;
import ksaito.study2023.gohara.domain.model.Taste;
import ksaito.study2023.gohara.domain.model.Type;
import ksaito.study2023.gohara.domain.repository.DishRepository;
import ksaito.study2023.gohara.infrastructure.store.DishRepositoryImpl;

/** 料理を提案するクラス. */
public class Suggest implements Application {
  private final DishRepository dishRepository;

  public Suggest() {
    dishRepository = new DishRepositoryImpl();
  }

  @Override
  public void run(String[] args) throws AppException {
    System.out.print("\033[H\033[2J");
    System.out.println("【あなたが今食べたいと持っているものを当てます。】");
    System.out.println("質問に対して半角数字を入力して回答してください。");

    try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
      var searchedByCategory = new LinkedList<Dish>();
      var searchedByType = new LinkedList<Dish>();
      var searchedByTaste = new LinkedList<Dish>();
      var category = new AtomicReference<Category>();
      var type = new AtomicReference<Type>();
      var taste = new AtomicReference<Taste>();

      // カテゴリ検索
      while (searchedByCategory.isEmpty()) {
        System.out.println();
        System.out.println("・カテゴリ");
        Arrays.stream(Category.values()).distinct().forEach(System.out::println);
        var tmpEnum = CodeEnum.getByIndex(Category.class, Integer.parseInt(readInput(reader)));
        if (Objects.isNull(tmpEnum)) {
          System.out.println("存在しない選択肢が選択されました。別の選択肢を選択してください。");
          continue;
        }
        category.set(tmpEnum);
        searchedByCategory.addAll(dishRepository.search(category.get(), null, null));
        if (searchedByCategory.isEmpty()) {
          System.out.println("そのカテゴリの食べものは登録されていません、別の選択肢を選択してください。");
        }
      }
      var result = new LinkedList<>(searchedByCategory);

      // タイプ検索
      while (searchedByType.isEmpty()) {
        System.out.println();
        System.out.println("・タイプ");
        Arrays.stream(Type.values())
          .filter(e -> result.stream().anyMatch(r -> r.types().contains(e)))
          .distinct()
          .forEach(System.out::println);
        var tmpEnum = CodeEnum.getByIndex(Type.class, Integer.parseInt(readInput(reader)));
        if (Objects.isNull(tmpEnum)) {
          System.out.println("存在しない選択肢が選択されました。別の選択肢を選択してください。");
          continue;
        }
        type.set(tmpEnum);
        searchedByType.addAll(dishRepository.search(category.get(), type.get(), null));
      }
      result.addAll(0, searchedByType);

      // 味検索
      while (searchedByTaste.isEmpty()) {
        System.out.println();
        System.out.println("・味");
        Arrays.stream(Taste.values())
          .filter(e -> result.stream().anyMatch(r -> r.tastes().contains(e)))
          .distinct()
          .forEach(System.out::println);
        var tmpEnum = CodeEnum.getByIndex(Taste.class, Integer.parseInt(readInput(reader)));
        if (Objects.isNull(tmpEnum)) {
          System.out.println("存在しない選択肢が選択されました。別の選択肢を選択してください。");
          continue;
        }
        taste.set(tmpEnum);
        searchedByTaste.addAll(0, dishRepository.search(category.get(), type.get(), taste.get()));
      }
      result.addAll(0, searchedByTaste);

      // 結果表示
      for (var i = 0; i < 10; i++) {
        System.out.print(".");
        TimeUnit.MILLISECONDS.sleep(500);
      }
      System.out.println();
      System.out.println();
      System.out.println("あなたが食べないものは以下のいずれかではないでしょうか。");
      result.stream()
          .distinct()
          .sorted(
              (a, b) ->
                  b.precisionRate(List.of(category.get()), List.of(type.get()), List.of(taste.get()))
                      .compareTo(
                          a.precisionRate(List.of(category.get()), List.of(type.get()), List.of(taste.get()))))
          .forEach(
              r ->
                  System.out.printf(
                      "%s（精度率：%f％）%n",
                      r.name(), r.precisionRate(List.of(category.get()), List.of(type.get()), List.of(taste.get()))));
    } catch (IOException | InterruptedException e) {
      throw new AppException(e);
    }
  }

  private String readInput(BufferedReader reader) throws IOException {
    var input = "";
    while (!Validator.integer(input)) {
      if (!input.isEmpty()) {
        System.out.println("入力は1〜8桁の半角整数にしてください。");
      }
      input = reader.readLine();
    }
    return input;
  }
}
