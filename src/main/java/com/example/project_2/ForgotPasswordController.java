package com.example.project_2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ForgotPasswordController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LoginButton;

    @FXML
    private TextField LoginField;

    @FXML
    private PasswordField NewPasswordField;

    @FXML
    private Button ChangeButton;

    @FXML
    void initialize() {
        ChangeButton.setOnAction(event -> {
            if(NewPasswordField.getText().length()<10) {
                forgotPassword(LoginField.getText(), NewPasswordField.getText());
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("password must be no more than 9 characters");
                alert.show();
            }
        });

        LoginButton.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("LoginP.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ChangeButton.getScene().getWindow().hide();

            Parent parent = loader.getRoot();
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(parent));
            primaryStage.show();
        });
    }

    void forgotPassword(String login, String email) {
        File file = new File("users");
        try {
            RandomAccessFile file1 = new RandomAccessFile(file, "rw");

            String s;

            while((s = file1.readLine()) != null) {
                if(s.equals("username: "+login)) {
                    file1.seek(file1.getFilePointer());
                    file1.writeBytes("password: "+ String.format("%-9s", NewPasswordField.getText())+"\n");
                    System.out.println("Changed");
                    break;
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

