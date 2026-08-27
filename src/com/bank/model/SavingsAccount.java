package com.bank.model;

import com.bank.exception.InsufficientFundsException;

public class SavingsAccount extends Account {
    private final double interestRate; // π.χ. 0.03 για 3%

    public SavingsAccount(String accountNumber, String accountHolder, double initialBalance, double interestRate) {
        super(accountNumber, accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (balance < amount) {
            throw new InsufficientFundsException("Savings account cannot be overdrawn. Available: " + balance);
        }
        balance -= amount;
    }

    public void applyInterest() {
        double interest = balance * interestRate;
        deposit(interest);
    }
}