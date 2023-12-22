package com.example.project_2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUserWriter implements UserWriter {

    private String filePath;

    public FileUserWriter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeUser(String username, String password, String email) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println("username: " + username);
            writer.println("password: " + password);
            writer.println("email: " + email);
            writer.println(); // Добавляем пустую строку для разделения пользователей
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

