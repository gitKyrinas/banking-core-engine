package com.bank.service;

import com.bank.exception.AccountNotFoundException;
import com.bank.exception.InsufficientFundsException;
import com.bank.model.Account;
import java.util.HashMap;
import java.util.Map;

public class BankService {
    private final Map<String, Account> accounts = new HashMap<>();

    public void registerAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account findAccount(String accountNumber) {
        Account acc = accounts.get(accountNumber);
        if (acc == null) {
            throw new AccountNotFoundException("Account " + accountNumber + " not found.");
        }
        return acc;
    }

    // Πολυμορφική μεταφορά χρημάτων
    public void transfer(String fromAccNum, String toAccNum, double amount) throws InsufficientFundsException {
        Account from = findAccount(fromAccNum);
        Account to = findAccount(toAccNum);

        from.withdraw(amount);
        to.deposit(amount);
    }
}