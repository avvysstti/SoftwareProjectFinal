package com.example.project_2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NewsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Economy;

    @FXML
    private Button ExitButton;

    @FXML
    private Button Sport;

    @FXML
    private Button Technology;

    @FXML
    void initialize() {
        Technology.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("EngineeringP.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Technology.getScene().getWindow().hide();

            Parent parent = loader.getRoot();
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(parent));
            primaryStage.show();
        });

        Sport.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("EduP.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Sport.getScene().getWindow().hide();

            Parent parent = loader.getRoot();
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(parent));
            primaryStage.show();
        });

        Economy.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("LawssP.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Economy.getScene().getWindow().hide();

            Parent parent = loader.getRoot();
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(parent));
            primaryStage.show();
        });

        ExitButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("LoginP.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ExitButton.getScene().getWindow().hide();

            Parent parent = loader.getRoot();
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(parent));
            primaryStage.show();
        });
    }
}
