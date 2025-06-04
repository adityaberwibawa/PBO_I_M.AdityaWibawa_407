package com.example.tugasmodul6.praktikum.users;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mahasiswa extends User {
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty NIM = new SimpleStringProperty();

    public Mahasiswa(String username, String password) {
        super(username, password);
    }

    public void displayAppMenu(){
        System.out.println(" ");
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public StringProperty getNIMProperty() {
        return NIM;
    }

    public String getName() {
        return name.get();
    }

    public String getNIM() {
        return NIM.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setNIM(String NIM) {
        this.NIM.set(NIM);
    }


}