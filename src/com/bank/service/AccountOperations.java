package com.bank.service;

import com.bank.exception.InsufficientFundsException;

public interface AccountOperations {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientFundsException;
    double getBalance();
}