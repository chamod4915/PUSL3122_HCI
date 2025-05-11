package org.furniwise.pusl3122_hci_project.Models;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

class SavingsAccount extends Account{
    // The withdrawal limit from the savings
    private final DoubleProperty withdrawalLimit;

    public SavingsAccount(String owner, String accountNumber, double balance, double withdrawalLimit) {
        super(owner, accountNumber, balance);
        this.withdrawalLimit = new SimpleDoubleProperty(this, "Withdrawal Limit", withdrawalLimit);
    }

    public DoubleProperty withdrawalLimitProp() {return withdrawalLimit;}


}