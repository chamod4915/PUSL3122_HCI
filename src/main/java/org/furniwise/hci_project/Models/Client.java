package org.furniwise.pusl3122_hci_project.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Client {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty payeeAddress;
    private final ObjectProperty<Account> checkingAccount;
    private final ObjectProperty<Account> savingsAccount;
    private final ObjectProperty<LocalDate> dateCreated;

    private final StringProperty userName;
    private final StringProperty email;

    public Client(String fName, String lName, String pAddress, Account cAccount, Account sAccount, LocalDate date,String uName,String email) {
        this.firstName = new SimpleStringProperty(this, "FirstName", fName);
        this.lastName = new SimpleStringProperty(this, "LastName", lName);
        this.payeeAddress = new SimpleStringProperty(this, "Payee Address", pAddress);
        this.checkingAccount = new SimpleObjectProperty<>(this, "Checking Account", cAccount);
        this.savingsAccount = new SimpleObjectProperty<>(this, "Savings Account", sAccount);
        this.dateCreated = new SimpleObjectProperty<>(this, "Date", date);
        this.userName = new SimpleStringProperty(this,"UserName",uName);
        this.email = new SimpleStringProperty(this,"Email",email);
    }

    public StringProperty firstNameProperty() {return firstName;}

    public StringProperty userNameProperty() {return userName;}

    public StringProperty emailProperty() {return email;}


    public StringProperty lastNameProperty() {return lastName;}

    public StringProperty pAddressProperty() {return payeeAddress;}

    public ObjectProperty<Account> checkingAccountProperty() {return checkingAccount;}

    public ObjectProperty<Account> savingsAccountProperty() {return savingsAccount;}

    public ObjectProperty<LocalDate> dateProperty() {return dateCreated;}
}