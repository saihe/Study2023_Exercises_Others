package ksaito.study2023.gohara.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category implements CodeEnum<Category> {
  Japanese(0, "和食"),
  Western(1, "洋食"),
  Chinese(2, "中華"),
  French(3, "フレンチ"),
  Italian(4, "イタリアン");

  private final int index;
  private final String name;

  public String toString() {
    return String.format("%d：%s", index, name);
  }
}
