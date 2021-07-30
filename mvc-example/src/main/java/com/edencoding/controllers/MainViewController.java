package com.edencoding.controllers;

import com.edencoding.models.FinancialAccount;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class MainViewController {

    //Model
    FinancialAccount account;

    //View nodes
    @FXML private Label accountHolder;
    @FXML private Label accountNumber;
    @FXML private Label accountBalance;
    @FXML private TextField amountTextField;

    public void initialize(){
        //get model
        account = new FinancialAccount("Maxwell Planck", 6626, 1000d);

        //link Model with View
        accountHolder.textProperty().bind(account.accountHolderProperty());
        accountBalance.textProperty().bind(account.accountBalanceProperty().asString());
        accountNumber.textProperty().bind(account.accountNumberProperty().asString());

        //link Controller to View - ensure only numeric input (integers) in text field
        amountTextField.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getText().matches("\\d+") || change.getText().equals("")) {
                return change;
            } else {
                change.setText("");
                change.setRange(
                        change.getRangeStart(),
                        change.getRangeStart()
                );
                return change;
            }
        }));
    }

    @FXML private void handleDeposit(Event event) {
        account.deposit(getAmount());
        event.consume();
    }

    @FXML private void handleWithdrawal(Event event) {
        account.withdraw(getAmount());
        event.consume();
    }

    private double getAmount(){
        if (amountTextField.getText().equals("")) return 0;

        return Double.parseDouble(amountTextField.getText());
    }
}
