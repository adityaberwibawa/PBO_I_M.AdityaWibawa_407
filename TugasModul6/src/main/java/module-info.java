module com.example.tugasmodul6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.tugasmodul6 to javafx.fxml;
    exports com.example.tugasmodul6.praktikum.gui;
    exports com.example.tugasmodul6.praktikum.data;
    exports com.example.tugasmodul6.praktikum.users;
}