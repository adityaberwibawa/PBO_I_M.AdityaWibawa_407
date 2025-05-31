package com.example.modul_6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        TebakAngkaView view = new TebakAngkaView();
        Scene scene = new Scene(view.getRoot(), 400, 250);

        primaryStage.setTitle("Tebak dong angka yossua anjaymabar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
