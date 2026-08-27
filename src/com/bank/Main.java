package com.bank;

import com.bank.model.CheckingAccount;
import com.bank.model.SavingsAccount;
import com.bank.service.BankService;

public class Main {
    public static void main(String[] args) {
        BankService bank = new BankService();

        SavingsAccount sa = new SavingsAccount("SA101", "Nikos P.", 1000.0, 0.05);
        CheckingAccount ca = new CheckingAccount("CA202", "Eleni K.", 500.0, 200.0);

        bank.registerAccount(sa);
        bank.registerAccount(ca);

        try {
            System.out.println("Executing transfer...");
            bank.transfer("CA202", "SA101", 600.0); // Επιτρέπεται λόγω overdraft limit
            System.out.println("Checking Balance: " + ca.getBalance());
            System.out.println("Savings Balance: " + sa.getBalance());

            System.out.println("\nApplying interest to savings...");
            sa.applyInterest();
            System.out.println("New Savings Balance: " + sa.getBalance());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}