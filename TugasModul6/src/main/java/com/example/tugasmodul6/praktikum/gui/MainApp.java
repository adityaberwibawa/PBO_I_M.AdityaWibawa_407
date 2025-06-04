package com.example.tugasmodul6.praktikum.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application{
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lost lan Found Anggi Jelek");
        primaryStage.setScene(LoginPane.getInstance().getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}