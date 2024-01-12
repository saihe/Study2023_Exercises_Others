package ksaito.study2023.nozaki.domain.repository;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import ksaito.study2023.nozaki.domain.model.Balance;

import java.io.IOException;
import java.util.List;

public interface BalanceRepository {
  /**
   * 一覧を取得する.
   * @return .
   */
  List<Balance> listAll() throws IOException;

  /**
   * レコードを保存する.
   * @param record .
   */
  void save(Balance record) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException;
}
