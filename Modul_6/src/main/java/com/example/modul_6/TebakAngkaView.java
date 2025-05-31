package com.example.modul_6;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.Random;

public class TebakAngkaView {
    private VBox root;
    private int angkaAcak;
    private int percobaan;

    public TebakAngkaView() {
        root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #3bedbe;-fx-padding: 20;");

        Random random = new Random();
        angkaAcak = random.nextInt(100) + 1;
        percobaan = 0;

        Label judul = new Label("⚠🙈🍌Tebak Angka 1–100");
        judul.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0d47a1;");

        Label feedback = new Label();
        feedback.setStyle("-fx-font-size: 16px; -fx-text-fill: #ff9800;");

        TextField inputField = new TextField();
        inputField.setPromptText("Masukkan angka di sini");
        inputField.setPrefWidth(150);
        inputField.setStyle("-fx-font-size: 14px;");

        Button tombolTebak = new Button("Coba Tebak!");
        tombolTebak.setStyle("-fx-background-color: #4caf50; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 5 15;");

        Label labelPercobaan = new Label("Jumlah percobaan: 0");
        labelPercobaan.setStyle("-fx-font-size: 12px; -fx-text-fill: #0d47a1;");

        tombolTebak.setOnAction(e -> {
            String input = inputField.getText();
            try {
                int tebakan = Integer.parseInt(input);
                percobaan++;
                labelPercobaan.setText("Jumlah percobaan: " + percobaan);

                if (tebakan > angkaAcak) {
                    feedback.setText("⚠Terlala gede!");
                } else if (tebakan < angkaAcak) {
                    feedback.setText("⚠Terlala keciiiil!");
                } else {
                    feedback.setText("✅Tebakan terlalu benar!");
                    tombolTebak.setText("Main Lagi");
                    angkaAcak = random.nextInt(100) + 1;
                    percobaan = 0;
                }
            } catch (NumberFormatException ex) {
                feedback.setText("Masukkan angka yang valid!");
            }
            inputField.clear();
        });

        HBox inputBox = new HBox(10, inputField, tombolTebak);
        inputBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(judul, feedback, inputBox, labelPercobaan);
    }

    public VBox getRoot() {
        return root;
    }
}

