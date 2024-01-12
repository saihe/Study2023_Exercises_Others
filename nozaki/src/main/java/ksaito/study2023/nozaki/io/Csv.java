package ksaito.study2023.nozaki.io;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * CSV入出力クラス.
 * @param <T> CSVに対するBean
 */
public class Csv<T> {
  private final Class<T> parameterClass;
  public Csv(Class<T> clazz) {
    parameterClass = clazz;
  }

  /**
   * CSVを全行読み込んでListで返す.
   * @param csvFilePath 読み込み対象CSVファイルパス
   * @return .
   * @throws FileNotFoundException .
   * @throws IOException .
   */
  public List<T> readAll(Path csvFilePath) throws FileNotFoundException, IOException {
    try (var reader = new CSVReader(new FileReader(csvFilePath.toFile()))) {
      return new CsvToBeanBuilder<T>(reader)
        .withType(parameterClass)
        .build()
        .parse();
    }
  }

  public void write(Path csvFilePath, T row) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
    try (var writer = new FileWriter(csvFilePath.toFile(), true)) {
      var beanToCsv = new StatefulBeanToCsvBuilder<T>(writer).withApplyQuotesToAll(false).build();
      beanToCsv.write(row);
    }
  }
}
