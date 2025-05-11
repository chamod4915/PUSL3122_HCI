package org.furniwise.pusl3122_hci_project.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Admin {
    private final StringProperty id;
    private final StringProperty username;
    private final StringProperty password;

    public Admin(String id, String username, String password) {
        this.id = new SimpleStringProperty(this, "ID", id);
        this.username = new SimpleStringProperty(this, "Username", username);
        this.password = new SimpleStringProperty(this, "Password", password);
    }

    public StringProperty idProperty() {
        return id;
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }
}
