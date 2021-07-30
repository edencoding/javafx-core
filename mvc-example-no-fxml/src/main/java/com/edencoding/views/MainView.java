package com.edencoding.views;

import com.edencoding.MVCExampleWithoutFXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class MainView {

    //View Nodes
    Label accountHolderText = new Label("");
    Label accountNumberText = new Label("");
    Label accountBalanceText = new Label("");
    Button withdrawalButton = new Button("Withdraw");
    Button depositButton = new Button("Deposit");
    TextField amountTextField;

    //View
    Parent view;

    public MainView() {
        view = createView();
    }

    public Label getAccountHolderDetailsLabel() {
        return accountHolderText;
    }

    public Label getAccountNumberDetailsLabel() {
        return accountNumberText;
    }

    public Label getAccountBalanceDetailsLabel() {
        return accountBalanceText;
    }

    public Button getWithdrawalButton() {
        return withdrawalButton;
    }

    public Button getDepositButton() {
        return depositButton;
    }

    public TextField getAmountTextField() {
        return amountTextField;
    }

    private VBox createView(){
        VBox vBox = new VBox(15);
        vBox.setPrefWidth(300);
        vBox.setPrefHeight(250);
        vBox.setPadding(new Insets(15));
        vBox.getStylesheets().addAll(MVCExampleWithoutFXML.class.getResource("/css/styles.css").toExternalForm());

        vBox.getChildren().add(createTitle());
        vBox.getChildren().add(createAccountDetails());
        vBox.getChildren().add(createDepositWithdrawalButtons());
        return vBox;
    }

    private Node createTitle(){
        Label titleLabel = new Label("Bank Account");
        titleLabel.getStyleClass().add("title");
        titleLabel.setMaxWidth(600);
        return titleLabel;
    }

    private Node createAccountDetails() {
        GridPane gridPane = new GridPane();

        Label accountHolderLabel = new Label("Account holder:");
        Label accountNumberLabel = new Label("Account holder:");
        Label accountBalanceLabel = new Label("Account holder:");
        accountHolderLabel.getStyleClass().add("bold");
        accountNumberLabel.getStyleClass().add("bold");
        accountBalanceLabel.getStyleClass().add("bold");

        GridPane.setRowIndex(accountNumberLabel, 1);
        GridPane.setRowIndex(accountBalanceLabel, 2);
        GridPane.setConstraints(accountHolderText, 1, 0);
        GridPane.setConstraints(accountNumberText, 1, 1);
        GridPane.setConstraints(accountBalanceText, 1, 2);

        gridPane.getChildren().addAll(
                accountHolderLabel, accountNumberLabel, accountBalanceLabel,
                accountHolderText, accountNumberText, accountBalanceText
        );

        gridPane.getRowConstraints().addAll(
                new RowConstraints(30, 100, 500, Priority.SOMETIMES, VPos.BASELINE, true),
                new RowConstraints(30, 100, 500, Priority.SOMETIMES, VPos.BASELINE, true),
                new RowConstraints(30, 100, 500, Priority.SOMETIMES, VPos.BASELINE, true)
        );
        gridPane.getColumnConstraints().addAll(
                new ColumnConstraints(10, 100, 500, Priority.SOMETIMES, HPos.CENTER, true),
                new ColumnConstraints(10, 100, 500, Priority.SOMETIMES, HPos.CENTER, true),
                new ColumnConstraints(10, 100, 500, Priority.SOMETIMES, HPos.CENTER, true)
        );

        return gridPane;
    }

    private Node createDepositWithdrawalButtons() {
        HBox hBox = new HBox(15);
        amountTextField = new TextField();
        amountTextField.setPromptText("Number");
        amountTextField.setPrefWidth(75);

        hBox.getChildren().addAll(withdrawalButton, amountTextField, depositButton);
        return hBox;
    }

    public Parent getView() {
        return view;
    }
}
