package com.avirup.determinantsolver;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField field_a1, field_a2, field_a3, field_b1, field_b2, field_b3, field_c1, field_c2, field_c3, field_answer;
    @FXML
    private Label label_determinant_solver, label_numberFormatException;
    @FXML
    private AnchorPane anchor_pane;
    @FXML
    private Button info_button;

    public void run_solve(){
        try {
            if (Objects.equals(field_a1.getText(), "") || Objects.equals(field_a2.getText(), "") || Objects.equals(field_a3.getText(), "") || Objects.equals(field_b1.getText(), "") || Objects.equals(field_b2.getText(), "") || Objects.equals(field_b3.getText(), "") || Objects.equals(field_c1.getText(), "") || Objects.equals(field_c2.getText(), "") || Objects.equals(field_c3.getText(), ""))
                return;
            double field_a1_value = Double.parseDouble(field_a1.getText());
            double field_a2_value = Double.parseDouble(field_a2.getText());
            double field_a3_value = Double.parseDouble(field_a3.getText());
            double field_b1_value = Double.parseDouble(field_b1.getText());
            double field_b2_value = Double.parseDouble(field_b2.getText());
            double field_b3_value = Double.parseDouble(field_b3.getText());
            double field_c1_value = Double.parseDouble(field_c1.getText());
            double field_c2_value = Double.parseDouble(field_c2.getText());
            double field_c3_value = Double.parseDouble(field_c3.getText());
            double result = field_a1_value * (field_b2_value * field_c3_value - field_b3_value * field_c2_value)
                    - field_a2_value * (field_b1_value * field_c3_value - field_b3_value * field_c1_value)
                    + field_a3_value * (field_b1_value * field_c2_value - field_b2_value * field_c1_value);
            String result_string = String.valueOf(result);
            field_answer.setText(result_string.endsWith(".0") ? result_string.substring(0, result_string.length() - 2) : result_string);
            label_numberFormatException.setVisible(false);
        }catch(NumberFormatException e){
            label_numberFormatException.setVisible(true);
        }
    }

    public void run_reset(){
        field_a1.setText("");
        field_a2.setText("");
        field_a3.setText("");
        field_b1.setText("");
        field_b2.setText("");
        field_b3.setText("");
        field_c1.setText("");
        field_c2.setText("");
        field_c3.setText("");
        field_answer.setText("");
        label_numberFormatException.setVisible(false);
    }

    public void show_info(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setResizable(false);
        alert.setTitle("Determinant Solver");
        alert.setHeaderText(null);
        alert.setContentText("""
                Determinant Solver v1.0
                Author: Avirup Banerjee
                
                This is a Determinant Solver made by me. Hope you like it""");
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("app_icon.png"));
        alert.show();
    }

    public void solve_runner(KeyEvent event){
        if (event.getCode().equals(KeyCode.ENTER))
            run_solve();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            label_determinant_solver.requestFocus();
            field_answer.focusedProperty().addListener((arg0, oldPropertyValue, newPropertyValue) -> {
                if (newPropertyValue)
                    field_answer.getParent().requestFocus();
            });
            anchor_pane.setOnMouseClicked(event -> anchor_pane.requestFocus());
            info_button.setGraphic(new ImageView(new Image("info.png", 18, 18, false, true, true)));
            info_button.setBackground(anchor_pane.getBackground());
        });
    }
}