package ksaito.study2023.nozaki.io;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.util.Arrays;
import ksaito.study2023.nozaki.domain.model.Balance;
import org.junit.jupiter.api.Test;

class CsvTest {

  @Test
  void readAll() {
    assertDoesNotThrow(() -> {
      var path = Files.createTempFile("csv_test_read_all", "");
      var expected = Arrays.asList("1000,2000", "3000,4000");
      Files.write(path, expected);

      assertIterableEquals(
        expected,
        new Csv<>(Balance.class).readAll(path).stream().map(Balance::toCsv).toList()
      );
    });
  }

  @Test
  void write() {
    assertDoesNotThrow(() -> {
      var path = Files.createTempFile("csv_test_write", "");
      var data1 = new Balance("1000", "2000");
      var data2 = new Balance("3000", "4000");

      var csv = new Csv<>(Balance.class);
      csv.write(path, data1);
      csv.write(path, data2);
      assertIterableEquals(
        Arrays.asList("1000,2000", "3000,4000"),
        Files.readAllLines(path)
      );
    });
  }
}
