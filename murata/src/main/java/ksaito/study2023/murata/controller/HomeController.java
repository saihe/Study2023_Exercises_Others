package ksaito.study2023.murata.controller;

import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ksaito.study2023.murata.domain.model.Subscription;
import ksaito.study2023.murata.domain.repository.SubscriptionRepository;
import ksaito.study2023.murata.infrastructure.memory.SubscriptionRepositoryImpl;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationMessage;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

public class HomeController {
  @FXML
  private Label snackbar;
  @FXML
  private ImageView showRegisterDialogButton;
  @FXML
  private DatePicker yearMonthFilter;
  @FXML
  private Label yearlyFee;
  @FXML
  private Label monthlyFee;
  @FXML
  private TableView<Subscription> subscriptions;
  @FXML
  private TableColumn<Subscription, String> name;
  @FXML
  private TableColumn<Subscription, Integer> price;
  @FXML
  private TableColumn<Subscription, String> remarks;
  @FXML
  private DialogPane registerDialog;
  @FXML
  private TextField inputName;
  @FXML
  private TextField inputPrice;
  @FXML
  private TextField inputRemarks;
  private ValidationSupport validationSupport;
  private SubscriptionRepository subscriptionRepository;

  @FXML
  void initialize() {
    subscriptionRepository = new SubscriptionRepositoryImpl();
    snackbar.setVisible(false);
    registerDialog.setVisible(false);
    registerDialog.lookupButton(ButtonType.APPLY).setOnMouseClicked(event -> {
      registerDialog.setVisible(!save());
    });
    registerDialog.lookupButton(ButtonType.CANCEL).setOnMouseClicked(event -> {
      registerDialog.setVisible(false);
    });
    validationSupport = new ValidationSupport();
    validationSupport.registerValidator(
      inputName,
      Validator.createEmptyValidator("必須項目です。")
    );
    validationSupport.registerValidator(
      inputPrice,
      Validator.createRegexValidator(
        "不正な金額が入力されています。",

        "^-?[0-9]+$", Severity.ERROR
      )
    );

    name.setCellValueFactory(new PropertyValueFactory<>("name"));
    price.setCellValueFactory(new PropertyValueFactory<>("price"));
    remarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
    subscriptions.getItems().add(new Subscription());
    showList();
  }

  @FXML
  void showRegisterDialog(MouseEvent mouseEvent) {
    registerDialog.setVisible(true);
  }

  @FXML
  boolean save() {
    if (validationSupport.isInvalid()) {
      snackbar.setText(validationSupport.getValidationResult().getMessages()
        .stream().map(ValidationMessage::getText).collect(Collectors.joining("\n")));
      snackbar.setVisible(true);
      return false;
    }
    subscriptionRepository.save(
      new Subscription(inputName.getText(), Integer.parseInt(inputPrice.getText()), inputRemarks.getText())
    );
    snackbar.setVisible(false);
    inputName.setText("");
    inputPrice.setText("");
    inputRemarks.setText("");
    showList();
    return true;
  }

  @FXML
  void showList() {
    subscriptions.setItems(FXCollections.observableArrayList(subscriptionRepository.list()));
  }
}
