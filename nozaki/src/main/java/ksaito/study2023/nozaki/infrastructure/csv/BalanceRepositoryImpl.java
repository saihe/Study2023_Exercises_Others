package ksaito.study2023.nozaki.infrastructure.csv;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import ksaito.study2023.nozaki.domain.model.Balance;
import ksaito.study2023.nozaki.domain.repository.BalanceRepository;
import ksaito.study2023.nozaki.io.Csv;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class BalanceRepositoryImpl implements BalanceRepository {
  private final Path dataSource;
  private final Csv<Balance> csv;

  public BalanceRepositoryImpl() {
    dataSource = Path.of("./", "nozaki_balance.csv");
    csv = new Csv<>(Balance.class);
  }

  @Override
  public List<Balance> listAll() throws IOException {
    return csv.readAll(dataSource);
  }

  @Override
  public void save(Balance record) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
    csv.write(dataSource, record);
  }
}
