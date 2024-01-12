package ksaito.study2023.nozaki.domain.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 収支モデル.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Balance {
  /** 収入. */
  @CsvBindByPosition(position = 0, required = true)
  private BigDecimal income;
  /** 支出. */
  @CsvBindByPosition(position = 1, required = true)
  private BigDecimal expenditure;

  public Balance(String income, String expenditure) throws NumberFormatException {
    this(new BigDecimal(income), new BigDecimal(expenditure));
  }

  /**
   * 収入-支出を計算した結果を返す.
   * @return 収支
   */
  public BigDecimal totalAmount() {
    return income.subtract(expenditure);
  }

  public String toCsv() {
    return income + "," + expenditure;
  }
  public String toString() {
    return String.format("%,10d\t%,10d", income.intValueExact(), expenditure.intValueExact());
  }
}
