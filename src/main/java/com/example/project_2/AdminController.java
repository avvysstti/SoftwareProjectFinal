package com.example.project_2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackButton;

    @FXML
    private Button LoginButton;

    @FXML
    private TextField LoginField;

    @FXML
    private PasswordField PasswordField;

    private  String AdminLogin = "Ayan";
    private  String AdminPassword = "0785";

    @FXML
    void initialize() {
        BackButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("LoginP.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            BackButton.getScene().getWindow().hide();

            Parent parent = loader.getRoot();
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(parent));
            primaryStage.show();
        });

        LoginButton.setOnAction(event -> {
            if(LoginField.getText().equals(AdminLogin) && PasswordField.getText().equals(AdminPassword)) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("NewsP.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                LoginButton.getScene().getWindow().hide();

                Parent parent = loader.getRoot();
                Stage primaryStage = new Stage();
                primaryStage.setScene(new Scene(parent));
                primaryStage.show();
            }
        });
    }
}

