package com.example.tugasmodul6.praktikum.gui;

import com.example.tugasmodul6.praktikum.data.Data;
import com.example.tugasmodul6.praktikum.data.Item;
import com.example.tugasmodul6.praktikum.users.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdminDashboard {
    private VBox root;

    public AdminDashboard(Admin admin) {
        root = new VBox(20);
        root.setStyle("-fx-background-color: #547792; -fx-padding: 20;");


        Label welcomeLabel = new Label("Halo, min ");
        welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #ECEFCA;");


        Label reportLabel = new Label("Laporan Barang");
        reportLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #ECEFCA;");

        TableView<Item> itemTableView = new TableView<>();
        TableColumn<Item, String> nameColumn = new TableColumn<>("Nama");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getItemNameProperty());
        nameColumn.setPrefWidth(150);

        TableColumn<Item, String> locColumn = new TableColumn<>("Lokasi");
        locColumn.setCellValueFactory(cellData -> cellData.getValue().getLocationProperty());
        locColumn.setPrefWidth(150);

        TableColumn<Item, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().getStatusProperty());
        statusColumn.setPrefWidth(150);

        itemTableView.getColumns().addAll(nameColumn, locColumn, statusColumn);
        itemTableView.getItems().setAll(Data.reportedItems);

        Button markClaimedButton = new Button("Tandai Claimed");
        markClaimedButton.setStyle("-fx-background-radius: 20px;-fx-padding: 10px 20px;-fx-font-size: 14px; -fx-background-color: #ECEFCA; -fx-text-fill: black; -fx-prompt-text-fill: dark-grey; -fx-border-radius: 4px;");
        markClaimedButton.setOnAction(e -> {
            Item selectedItem = itemTableView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                selectedItem.setStatus("Claimed");
                itemTableView.refresh();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Peringatan");
                alert.setHeaderText(null);
                alert.setContentText("Pilih barang terlebih dahulu!");
                alert.showAndWait();
            }
        });

        HBox itemControls = new HBox(10, markClaimedButton);
        VBox itemSection = new VBox(10, reportLabel, itemTableView, itemControls);


        Label studentDataLabel = new Label("Data Mahasiswa");
        studentDataLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #ECEFCA;");

        TableView<Mahasiswa> studentTableView = new TableView<>();
        studentTableView.setStyle("-fx-text-fill: black;");

        TableColumn<Mahasiswa, String> studentNameColumn = new TableColumn<>("Nama");
        studentNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        studentNameColumn.setPrefWidth(200);

        TableColumn<Mahasiswa, String> studentNimColumn = new TableColumn<>("NIM");
        studentNimColumn.setCellValueFactory(cellData -> cellData.getValue().getNIMProperty());
        studentNimColumn.setPrefWidth(200);

        studentTableView.getColumns().addAll(studentNameColumn, studentNimColumn);
        studentTableView.getItems().setAll(Data.userList.stream().filter(user -> user instanceof Mahasiswa).map(user -> (Mahasiswa) user).toList());

        TextField studentNameInput = new TextField();
        studentNameInput.setPromptText("Nama Mahasiswa");
        studentNameInput.setStyle("-fx-background-radius: 20px;-fx-padding: 10px 20px;-fx-font-size: 14px; -fx-background-color: #ECEFCA; -fx-text-fill: black; -fx-prompt-text-fill: dark-grey; -fx-border-radius: 4px;");
        studentNameInput.setPrefWidth(150);

        TextField studentNimInput = new TextField();
        studentNimInput.setPromptText("NIM");
        studentNimInput.setStyle("-fx-background-radius: 20px;-fx-padding: 10px 20px;-fx-font-size: 14px; -fx-background-color: #ECEFCA; -fx-text-fill: black; -fx-prompt-text-fill: dark-grey; -fx-border-radius: 4px;");
        studentNimInput.setPrefWidth(150);

        Button addButton = new Button("➕");
        addButton.setStyle("-fx-background-radius: 20px;-fx-padding: 10px 20px;-fx-font-size: 14px; -fx-background-color: #ECEFCA; -fx-text-fill: black; -fx-prompt-text-fill: dark-grey; -fx-border-radius: 4px;");
        addButton.setOnAction(e -> {
            String name = studentNameInput.getText();
            String nim = studentNimInput.getText();
            if (!name.isEmpty() && !nim.isEmpty()) {
                Data.userList.add(new Mahasiswa(name, nim));
                studentTableView.refresh();
                studentNameInput.clear();
                studentNimInput.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Peringatan");
                alert.setHeaderText(null);
                alert.setContentText("Mohon isi semua field!");
                alert.showAndWait();
            }
        });

        Button deleteButton = new Button("🚮");
        deleteButton.setStyle("-fx-background-radius: 20px;-fx-padding: 10px 20px;-fx-font-size: 14px; -fx-background-color: #ECEFCA; -fx-text-fill: black; -fx-prompt-text-fill: dark-grey; -fx-border-radius: 4px;");
        deleteButton.setOnAction(e -> {
            Mahasiswa selectedStudent = studentTableView.getSelectionModel().getSelectedItem();
            if (selectedStudent != null) {
                Data.userList.remove(selectedStudent);
                studentTableView.refresh();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Peringatan");
                alert.setHeaderText(null);
                alert.setContentText("Pilih mahasiswa terlebih dahulu!");
                alert.showAndWait();
            }
        });

        HBox studentControls = new HBox(10, studentNameInput, studentNimInput, addButton, deleteButton);
        VBox studentSection = new VBox(10, studentDataLabel, studentTableView, studentControls);

        SplitPane splitPane = new SplitPane(itemSection, studentSection);
        splitPane.setStyle("-fx-background-radius: 20px;-fx-padding: 10px 20px;-fx-font-size: 14px; -fx-background-color: #213448; -fx-text-fill: black; -fx-prompt-text-fill: dark-grey; -fx-border-radius: 4px;");
        splitPane.setDividerPositions(0.5);


        Button logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
        logoutButton.setOnAction(e -> {
            try {
                Stage stage = (Stage) logoutButton.getScene().getWindow();
                stage.setScene(new LoginPane().getScene());
            } catch (Exception ex) {
                ex.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Gagal beralih ke halaman login.");
                alert.showAndWait();
            }
        });

        root.getChildren().addAll(welcomeLabel, splitPane, logoutButton);
    }

    public Scene getScene() {
        return new Scene(root, 800, 600);
    }
}