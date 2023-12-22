package com.example.project_2;

public class UserWriterFactory {

    public static UserWriter createUserWriter(String filePath) {
        return new FileUserWriter(filePath);
    }
}

