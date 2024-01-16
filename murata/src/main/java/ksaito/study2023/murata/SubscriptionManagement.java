package ksaito.study2023.murata;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SubscriptionManagement extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(SubscriptionManagement.class.getResource("home.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 600, 450);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }

  public void run(String[] args) {
    launch(args);
  }
}
