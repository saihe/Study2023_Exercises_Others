package ksaito.study2023.nozaki;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import ksaito.study2023.common.exception.AppException;
import ksaito.study2023.common.Application;
import ksaito.study2023.nozaki.domain.model.Balance;
import ksaito.study2023.nozaki.domain.repository.BalanceRepository;
import ksaito.study2023.nozaki.infrastructure.csv.BalanceRepositoryImpl;

/**
 * 収支管理アプリ.
 */
public class IncomeAndExpenditureManagement implements Application {
  private final BalanceRepository balanceRepository;

  public IncomeAndExpenditureManagement() {
    balanceRepository = new BalanceRepositoryImpl();
  }

  @Override
  public void run(String[] args) throws AppException {
    try (var input = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.println("投資額を入力してください。");
      var income = input.readLine();
      while(!Validator.decimal(income)) {
        System.out.println("入力された金額が正しい書式ではありません。再度入力してください。");
        income = input.readLine();
      }

      System.out.println("払戻額を入力してください。");
      var expenditure = input.readLine();
      while(!Validator.decimal(expenditure)) {
        System.out.println("入力された金額が正しい書式ではありません。再度入力してください。");
        expenditure = input.readLine();
      }

      balanceRepository.save(new Balance(income, expenditure));
      System.out.println("****** 入力済み収支一覧を表示します。 ******");
      balanceRepository.listAll().forEach(System.out::println);
    } catch (IOException e) {
      throw new AppException("データソースの操作に失敗しました。", e);
    } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
      throw new AppException(e);
    }
  }
}
