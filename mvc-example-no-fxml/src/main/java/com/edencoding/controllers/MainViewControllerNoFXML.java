package com.edencoding.controllers;

import com.edencoding.models.FinancialAccount;
import com.edencoding.views.MainView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class MainViewControllerNoFXML {

    //Model
    FinancialAccount account;

    public MainViewControllerNoFXML(MainView view){
        setView(view);
    }

    public void setView(MainView view){
        //get model
        account = new FinancialAccount("Maxwell Planck", 6626, 1000d);

        //link Model with View
        view.getAccountHolderDetailsLabel().textProperty().bind(account.accountHolderProperty());
        view.getAccountBalanceDetailsLabel().textProperty().bind(account.accountBalanceProperty().asString());
        view.getAccountNumberDetailsLabel().textProperty().bind(account.accountNumberProperty().asString());

        //link Controller to View - ensure only numeric input (integers) in text field
        view.getAmountTextField().setTextFormatter(new TextFormatter<>(change -> {
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

        //link Controller to View - methods for buttons
        view.getDepositButton().setOnAction(event -> {
            account.deposit(getAmount(view.getAmountTextField()));
            event.consume();
        });
        view.getWithdrawalButton().setOnAction(event -> {
            account.withdraw(getAmount(view.getAmountTextField()));
            event.consume();
        });
    }

    private double getAmount(TextField field){
        if (field.getText().equals("")) return 0;

        return Double.parseDouble(field.getText());
    }
}
