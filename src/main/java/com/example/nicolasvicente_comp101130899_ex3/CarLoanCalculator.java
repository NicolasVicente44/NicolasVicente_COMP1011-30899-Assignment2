package com.example.nicolasvicente_comp101130899_ex3;

public class CarLoanCalculator {
    public double calculateInterest(double loanAmount, int loanDuration, double interestRate) {
        double monthlyInterestRate = interestRate / 100 / 12;
        int numberOfPayments = loanDuration;
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        return (monthlyPayment * numberOfPayments) - loanAmount;
    }

}
