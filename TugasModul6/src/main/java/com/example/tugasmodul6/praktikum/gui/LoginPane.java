package com.example.tugasmodul6.praktikum.gui;

import com.example.tugasmodul6.praktikum.data.*;
import com.example.tugasmodul6.praktikum.users.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPane {
    private static final LoginPane instance = new LoginPane();
    private final VBox root;
    private final Scene scene;

    public LoginPane(){
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #547792;-fx-padding: 20;");

        scene = new Scene(root, 400, 500);

        Label duljudul = new Label("⚠ LOST [LOGIN] FOUND ⚠");
        duljudul.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #213448;");

        ToggleGroup roleGroup = new ToggleGroup();
        RadioButton mahasiswaRadio = new RadioButton("Mahasiswa");
        mahasiswaRadio.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #ECEFCA;");
        RadioButton adminRadio = new RadioButton("Admin");
        adminRadio.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #ECEFCA;");
        mahasiswaRadio.setToggleGroup(roleGroup);
        adminRadio.setToggleGroup(roleGroup);
        mahasiswaRadio.setSelected(true);

        HBox role = new HBox(10, mahasiswaRadio, adminRadio);
        role.setAlignment(Pos.CENTER);

        TextField inputUsername = new TextField();
        inputUsername.setPromptText("username");
        inputUsername.setPrefWidth(150);
        inputUsername.setStyle("-fx-font-size: 14px; -fx-background-color: #ECEFCA; -fx-text-fill: #332D56; -fx-prompt-text-fill: dark-grey; -fx-border-radius: 4px;-fx-background-radius: 20px;-fx-padding: 10px 20px;");

        TextField inputPassword = new TextField();
        inputPassword.setPromptText("password");
        inputPassword.setPrefWidth(150);
        inputPassword.setStyle("-fx-font-size: 14px; -fx-background-color: #ECEFCA; -fx-text-fill: #332D56; -fx-prompt-text-fill: dark-grey; -fx-border-radius: 4px;-fx-background-radius: 20px;-fx-padding: 10px 20px;");

        Button tombolLogin = new Button("Login");
        tombolLogin.setAlignment(Pos.CENTER);
        tombolLogin.setStyle("-fx-background-color: #71C0BB;  -fx-font-weight: bold; -fx-padding: 5 15; -fx-text-fill: #332D56;-fx-background-radius: 20px;-fx-padding: 10px 20px;");

        Button klikme = new Button("Click me");
        klikme.setStyle("-fx-background-color: #71C0BB;  -fx-font-weight: bold; -fx-padding: 5 15; -fx-text-fill: #332D56;-fx-background-radius: 20px;-fx-padding: 10px 20px;");
        klikme.setAlignment(Pos.CENTER);
        klikme.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Success!!");
            alert.setHeaderText(null);
            alert.setContentText("Success!");
            alert.showAndWait();
        });

        Label statusLogin = new Label();
        statusLogin.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #CD5656;");

        VBox login = new VBox(10, role, inputUsername,inputPassword, tombolLogin, klikme);
        login.setStyle("-fx-font-size: 14px; -fx-background-color: #213448; -fx-text-fill: #332D56; -fx-prompt-text-fill: dark-grey; -fx-border-radius: 4px;-fx-background-radius: 20px;-fx-padding: 10px 20px;");

        root.getChildren().addAll(duljudul, login, statusLogin);

        tombolLogin.setOnAction(e -> {
            String username = inputUsername.getText();
            String password = inputPassword.getText();
            boolean apakahAdmin = adminRadio.isSelected();

            User user = auuuutentifikasi(username, password, apakahAdmin);

            if (user != null) {
                Stage stage = (Stage) tombolLogin.getScene().getWindow();
                if (user instanceof Admin) {
                    stage.setScene(new AdminDashboard((Admin) user).getScene());
                } else {
                    stage.setScene(new MahasiswaDashboard((Mahasiswa) user).getScene());
                }
            } else {
                statusLogin.setText("Login Gagaal!*, ada yang salah!");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Input Kosong");
                alert.setHeaderText(null);
                alert.setContentText("Login Gagaal!*, ada yang salah!");
                alert.showAndWait();
            }

        });
    }

    private User auuuutentifikasi(String username, String password, boolean apakahAdmin) {
        for (User user : Data.userList) {
            if (apakahAdmin && user instanceof Admin) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return user;
                }
            } else if (!apakahAdmin && user instanceof Mahasiswa) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return user;
                }
            }
        }
        return null;
    }

    public static LoginPane getInstance() {
        return instance;
    }

    public Scene getScene() {
        return scene;
    }


}
