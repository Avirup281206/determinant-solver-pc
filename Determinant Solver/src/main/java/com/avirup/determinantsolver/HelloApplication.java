package com.avirup.determinantsolver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Determinant Solver");
        stage.setScene(scene);
        stage.getIcons().add(new Image("app_icon.png"));
        stage.show();
        stage.setResizable(false);
        stage.setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit?", ButtonType.YES, ButtonType.NO);
            alert.setHeaderText(null);
            ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("app_icon.png"));
            alert.setTitle("Determinant Solver");
            ((Button) alert.getDialogPane().lookupButton(ButtonType.YES)).setDefaultButton(false);
            ((Button) alert.getDialogPane().lookupButton(ButtonType.NO)).setDefaultButton(true);
            alert.showAndWait().ifPresent(buttonType -> {
                if (buttonType.equals(ButtonType.NO))
                    event.consume();
            });
        });
    }

    public static void main(String[] args) {
        launch();
    }
}