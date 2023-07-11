package com.example.nicolasvicente_comp101130899_ex3;

import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ResourceBundle;


public class Exercise3Controller implements Initializable {


    @FXML
    private TextField carLoanAmountInput;

    @FXML
    private TextField carLoanDurationInput;

    @FXML
    private Button carLoanInterestCalculationBtn;

    @FXML
    private TextField carLoanInterestInput;

    @FXML
    private Text carLoanInterestOutput;

    @FXML
    private Button factorialCalculateBtn;

    @FXML
    private Text factorialCalculationOutput;

    @FXML
    private TextField factorialTextInput;

    private FactorialCalculator factorialCalculator;
    private CarLoanCalculator carLoanCalculator;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        factorialCalculator = new FactorialCalculator();
        carLoanCalculator = new CarLoanCalculator();

        factorialCalculateBtn.setOnAction(event -> calculateFactorial());
        carLoanInterestCalculationBtn.setOnAction(event -> calculateCarLoanInterest());
    }


    private void calculateFactorial() {
        String input = factorialTextInput.getText();
        Task<BigInteger> factorialTask = new Task<>() {
            @Override
            protected BigInteger call() throws Exception {
                int number = Integer.parseInt(input);
                return factorialCalculator.calculateFactorial(number);
            }
        };


        factorialTask.setOnSucceeded(event -> {
            BigInteger factorial = factorialTask.getValue();
            factorialCalculationOutput.setText(factorial.toString());
        });


        new Thread(factorialTask).start();
    }





    private void calculateCarLoanInterest() {
        double loanAmount = Double.parseDouble(carLoanAmountInput.getText());
        int loanDuration = Integer.parseInt(carLoanDurationInput.getText());
        double interestRate = Double.parseDouble(carLoanInterestInput.getText());

        double interest = carLoanCalculator.calculateInterest(loanAmount, loanDuration, interestRate);

        carLoanInterestOutput.setText(String.format("$%.2f", interest));
    }



}