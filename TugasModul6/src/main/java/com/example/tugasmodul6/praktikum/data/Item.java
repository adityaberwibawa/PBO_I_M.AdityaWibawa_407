package com.example.tugasmodul6.praktikum.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {
    private StringProperty itemName;
    private StringProperty description;
    private StringProperty location;
    private StringProperty status;

    public Item(String itemName, String description, String location, String status) {
        this.itemName = new SimpleStringProperty(itemName);
        this.description = new SimpleStringProperty(description);
        this.location = new SimpleStringProperty(location);
        this.status = new SimpleStringProperty(status);
    }


    public StringProperty getItemNameProperty() {
        return itemName;
    }

    public StringProperty getLocationProperty() {
        return location;
    }

    public StringProperty getDescriptionProperty() {
        return description;
    }

    public StringProperty getStatusProperty() {
        return status;
    }


    public String getItemName() {
        return itemName.get();
    }

    public String getDescription() {
        return description.get();
    }

    public String getLocation() {
        return location.get();
    }

    public String getStatus() {
        return status.get();
    }


    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}