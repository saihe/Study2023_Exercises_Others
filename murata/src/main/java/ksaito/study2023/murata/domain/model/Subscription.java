package ksaito.study2023.murata.domain.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.math.BigDecimal;

/**
 * サブスクリプションサービス.
 * @param name 名称
 * @param price 月額料金
 * @param remarks 備考
 */
public record Subscription(
  StringProperty name,
  IntegerProperty price,
  StringProperty remarks
) {
  public Subscription() {
    this(new SimpleStringProperty(""), new SimpleIntegerProperty(0), new SimpleStringProperty(""));
  }
  public Subscription(String name, Integer price, String remarks) {
    this(new SimpleStringProperty(name), new SimpleIntegerProperty(price), new SimpleStringProperty(remarks));
  }

  public StringProperty nameProperty() {
    return name;
  }

  public IntegerProperty priceProperty() {
    return price;
  }

  public StringProperty remarksProperty() {
    return remarks;
  }
}
