package com.example.tugasmodul6.praktikum.gui;

import com.example.tugasmodul6.praktikum.data.Data;
import com.example.tugasmodul6.praktikum.data.Item;
import com.example.tugasmodul6.praktikum.users.Mahasiswa;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


public class MahasiswaDashboard {
    private Scene scene;

    public MahasiswaDashboard(Mahasiswa mahasiswa){
        Label sapaan = new Label("Halo, selamat datang sam " + mahasiswa.getUsername()+"!");
        sapaan.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #ECEFCA;");

        Label judulForm = new Label("⚠Laporkan baranng temuan/hilang!");
        judulForm.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-text-fill: #ECEFCA;");

        Label labelNama = new Label("Nama Barang");
        Label labelDes = new Label("Deskripsi");
        Label labelLok = new Label("Lokasi");
        labelNama.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #ECEFCA;");
        labelDes.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #ECEFCA;");
        labelLok.setStyle("-fx-font-size: 11px; -fx-font-weight: bold; -fx-text-fill: #ECEFCA;");

        TextField namaItem = new TextField();
        namaItem.setStyle("-fx-background-radius: 20px;-fx-padding: 10px 20px;-fx-font-size: 14px; -fx-background-color: #ECEFCA; -fx-text-fill: black; -fx-prompt-text-fill: dark-grey; -fx-border-radius: 4px;");
        namaItem.setPromptText("Nama barang");

        TextField desItem = new TextField();
        desItem.setStyle("-fx-background-radius: 20px;-fx-padding: 10px 20px;-fx-font-size: 14px; -fx-background-color: #ECEFCA; -fx-text-fill: black; -fx-prompt-text-fill: dark-grey; -fx-border-radius: 4px;");
        desItem.setPromptText("Deskripsi");

        TextField lokasi = new TextField();
        lokasi.setPromptText("Lokasi");
        lokasi.setStyle("-fx-background-radius: 20px;-fx-padding: 10px 20px;-fx-font-size: 14px; -fx-background-color: #ECEFCA; -fx-text-fill: black; -fx-prompt-text-fill: dark-grey; -fx-border-radius: 4px;");

        Button tombolLapor = new Button("Laporkan");
        tombolLapor.setStyle("-fx-background-radius: 20px;-fx-padding: 10px 20px;-fx-background-color: #71C0BB; -fx-font-weight: bold; -fx-padding: 5 15; -fx-text-fill: #332D56;");

        GridPane gripForm = new GridPane();
        gripForm.setVgap(10);
        gripForm.setHgap(10);
        gripForm.add(judulForm, 0, 0);
        gripForm.add(labelNama, 0,1);
        gripForm.add(labelDes, 1,1);
        gripForm.add(labelLok, 2,1);
        gripForm.add(namaItem, 0, 2);
        gripForm.add(desItem,1, 2);
        gripForm.add(lokasi,2, 2);
        gripForm.add(tombolLapor, 3 ,2);

        VBox form = new VBox(10, sapaan, gripForm);
        form.setStyle("-fx-background-color: #213448; -fx-padding: 15; -fx-spacing: 10;-fx-background-radius: 20px;-fx-padding: 10px 20px;");



        Label judulLapor = new Label("Daftar laporan ");
        judulLapor.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #ECEFCA;-fx-background-radius: 20px;-fx-padding: 10px 20px;");

        TableView<Item> tableView = new TableView<>();
        tableView.setStyle("-fx-background-color: #ECEFCA; -fx-text-fill: #ECEFCA;");
        TableColumn<Item, String> nameColumn = new TableColumn<>("Nama");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getItemNameProperty());
        nameColumn.setPrefWidth(260);
        TableColumn<Item, String> desColumn = new TableColumn<>("Deskripsi");
        desColumn.setCellValueFactory(cellData -> cellData.getValue().getDescriptionProperty());
        desColumn.setPrefWidth(260);
        TableColumn<Item, String> locColumn = new TableColumn<>("Lokasi");
        locColumn.setCellValueFactory(cellData -> cellData.getValue().getLocationProperty());
        locColumn.setPrefWidth(260);


        tableView.getColumns().addAll(nameColumn, desColumn, locColumn);
        tableView.getItems().setAll(Data.getReportedItems());


        GridPane gridLapor = new GridPane();
        gridLapor.setHgap(10);
        gridLapor.setVgap(10);
        gridLapor.add(judulLapor, 1,0);
        gridLapor.add(tableView, 1, 1);

        HBox laporan = new HBox(20, gridLapor);
        laporan.setStyle("-fx-background-color: #547792; fx-padding: 150;-fx-background-radius: 20px;-fx-padding: 10px 20px;");

        tombolLapor.setOnAction(e -> {
            String nama = namaItem.getText();
            String deskripsi = desItem.getText();
            String lokasii = lokasi.getText();

            if (nama.isEmpty() || deskripsi.isEmpty() || lokasii.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Input Kosong");
                alert.setHeaderText(null);
                alert.setContentText("Harap lengkapi semua field!");
                alert.showAndWait();
                return;
            }

            Item newItem = new Item(nama, deskripsi, lokasii, "Reported");
            Data.reportedItems.add(newItem);

            tableView.getItems().clear();
            tableView.getItems().setAll(Data.getReportedItems());

            namaItem.clear();
            desItem.clear();
            lokasi.clear();

            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Berhasil");
            success.setHeaderText(null);
            success.setContentText("Barang berhasil dilaporkan!");
            success.showAndWait();
        });


        Button logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;-fx-background-radius: 20px;-fx-padding: 10px 20px;");
        logoutButton.setAlignment(Pos.TOP_LEFT);
        logoutButton.setOnAction(e -> {
            try {
                Stage stage = (Stage) logoutButton.getScene().getWindow();
                stage.setScene(new LoginPane().getScene());
                stage.centerOnScreen();
            } catch (Exception ex) {
                ex.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Gagal beralih ke halaman login.");
                alert.showAndWait();
            }
        });


        VBox layout = new VBox(20, form, laporan, logoutButton);
        layout.setAlignment(Pos.CENTER_LEFT);
        layout.setStyle("-fx-background-color: #547792; fx-padding: 20;");

        scene = new Scene(layout, 800, 600);
    }

    public Scene getScene() {
        return scene;
    }
}