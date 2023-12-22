package com.example.project_2;

import java.io.File;
import java.io.FileNotFoundException;
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

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField EmailField;

    @FXML
    private Button LoginButton;

    @FXML
    private TextField LoginField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button SignUpButton;

    @FXML
    void initialize() {
        LoginButton.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("LoginP.fxml"));

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
            if (CheckData(LoginField.getText(), PasswordField.getText(), EmailField.getText())) {
                if (CountLines(LoginField.getText(), EmailField.getText())) {
                    UserWriter userWriter = UserWriterFactory.createUserWriter("other_users_file.txt");
                    userWriter.writeUser(LoginField.getText(), PasswordField.getText(), EmailField.getText());
                    AddData(LoginField.getText(), PasswordField.getText(), EmailField.getText());
                }
            }
        });

    }

    void AddData(String login, String password, String email) {
        try {
            createFolder();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            createFolder();

            RandomAccessFile file = new RandomAccessFile("users", "rw");
            file.seek(file.length());
            file.writeBytes("username: " + LoginField.getText() + "\n");
            file.writeBytes("password: " + String.format("%-9s", PasswordField.getText()) + "\n");
            file.writeBytes("email : " + EmailField.getText() + "\n\n\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    void createFolder() throws FileNotFoundException {
        File file = new File("users");
        RandomAccessFile file1 = new RandomAccessFile(file, "rw");
    }

    boolean CheckData(String login, String password, String email) {
        boolean check = true;
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(login.equals("") || password.equals("") || email.equals("")) {
            check = false;
            System.out.println("fields is empty");
            alert.setContentText("fields is empty");
            alert.show();
        }
        else if(login.equals(password)) {
            check = false;
            System.out.println("Password Matched");
            alert.setContentText("Password Matched");
            alert.show();
        }
        else if(login.length()>9 || password.length()>9 || email.length()>9) {
            check = false;
            System.out.println("username, password and email to 9 characters");
            alert.setContentText("username, password and email to 9 characters");
            alert.show();
        }
        return check;
    }

    boolean CountLines(String login, String email) {
        boolean check = true;
        int x = 0;
        File file = new File("users");
        try {
            RandomAccessFile file1 = new RandomAccessFile(file, "rw");

            String s;

            while((s = file1.readLine()) != null) {
                x++;

                if(s.equals("username: "+login) || s.equals("email : "+email)) {
                    check = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("such user exists");
                    alert.show();
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("number of lines "+x);
        return check;
    }
}
