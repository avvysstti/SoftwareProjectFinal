package com.example.project_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AdminButton;

    @FXML
    private Button LoginButton;

    @FXML
    private TextField LoginField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button SignUpButton;

    @FXML
    private Button forgotPassword;

    @FXML
    private CheckBox rememberMe;

    @FXML
    void initialize() {
        AdminButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("AdminP.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            SignUpButton.getScene().getWindow().hide();

            Parent parent = loader.getRoot();
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(parent));
            primaryStage.show();
        });

        SignUpButton.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("SignUpP.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            SignUpButton.getScene().getWindow().hide();

            Parent parent = loader.getRoot();
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(parent));
            primaryStage.show();
        });

        forgotPassword.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("ForgotPasswordP.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            forgotPassword.getScene().getWindow().hide();

            Parent parent = loader.getRoot();
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(parent));
            primaryStage.show();
        });

        LoginButton.setOnAction(event -> {
            Logic(LoginField.getText(), PasswordField.getText());
        });

        rememberMe.setOnAction(event -> {
            if(rememberMe.isSelected()) {
                try {
                    RandomAccessFile file = new RandomAccessFile("rememberMe", "rw");
                    file.seek(0);
                    file.writeBytes(LoginField.getText() + "\n");
                    file.writeBytes(PasswordField.getText());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                RandomAccessFile file = null;
                try {
                    file = new RandomAccessFile("rememberMe", "rw");
                    file.seek(0);
                    file.writeBytes("         \n");
                    file.writeBytes("         ");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        boolean b = false;
        try {
            RandomAccessFile file = new RandomAccessFile("rememberMe", "rw");
            String s;
            if((s = file.readLine().trim()) != "") {
                LoginField.setText(s);
                PasswordField.setText(file.readLine());
                b = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        rememberMe.setSelected(b);
    }

    boolean Logic(String login, String password) {
        boolean check = false;
        File file = new File("users");
        try {
            RandomAccessFile file1 = new RandomAccessFile(file, "rw");

            String s;

            while((s = file1.readLine()) != null) {

                if(s.equals("username: "+login)) {
                    if(file1.readLine().trim().equals("password: "+password)) {
                        check = true;

                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("NewsP.fxml"));

                        try {
                            loader.load();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        SignUpButton.getScene().getWindow().hide();

                        Parent parent = loader.getRoot();
                        Stage primaryStage = new Stage();
                        primaryStage.setScene(new Scene(parent));
                        primaryStage.show();

                        System.out.println("User is found");
                    }
                }
            }

            if(!check) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User is not found");
                alert.show();
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return check;
    }
}
