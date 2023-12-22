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

public class EduController implements BaseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button HomeButton;

    @FXML
    void initialize() {
        setHomeButtonAction();
    }

    @Override
    public void setHomeButtonAction() {
        HomeButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("NewsP.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            HomeButton.getScene().getWindow().hide();

            Parent parent = loader.getRoot();
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(parent));
            primaryStage.show();
        });
    }
}

