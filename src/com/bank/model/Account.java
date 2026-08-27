package com.bank.model;

import com.bank.exception.InsufficientFundsException;
import com.bank.service.AccountOperations;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Account implements AccountOperations {
    private final String accountNumber;
    private final String accountHolder;
    protected double balance;
    private final List<Transaction> transactions;

    public Account(String accountNumber, String accountHolder, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        this.transactions.add(new Transaction("INITIAL_DEPOSIT", initialBalance));
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        transactions.add(new Transaction("DEPOSIT", amount));
    }

    // Abstract method: κάθε τύπος λογαριασμού ορίζει τον δικό του κανόνα ανάληψης
    @Override
    public abstract void withdraw(double amount) throws InsufficientFundsException;

    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    
    @Override
    public double getBalance() { return balance; }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}