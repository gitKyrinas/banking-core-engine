package com.bank.model;

import com.bank.exception.InsufficientFundsException;

public class CheckingAccount extends Account {
    private final double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolder, double initialBalance, double overdraftLimit) {
        super(accountNumber, accountHolder, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (balance + overdraftLimit < amount) {
            throw new InsufficientFundsException("Exceeded overdraft limit. Max allowed: " + (balance + overdraftLimit));
        }
        balance -= amount;
    }
}