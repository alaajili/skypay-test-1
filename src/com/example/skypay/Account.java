package com.example.skypay;

import com.example.skypay.exception.InsufficientFundsException;
import com.example.skypay.exception.InvalidAmountException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account implements AccountService {
    private int balance;
    private final List<Transaction> transactions;
    private final DateTimeFormatter dateFormatter;

    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Override
    public void deposit(int amount) {
        validateAmount(amount);

        balance += amount;
        Transaction transaction = new Transaction(LocalDate.now(), amount, balance);
        transactions.add(transaction);
    }

    @Override
    public void withdraw(int amount) {
        validateAmount(amount);

        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Insufficient funds. Current balance: " + balance + ", Withdrawal amount: " + amount
            );
        }

        balance -= amount;
        Transaction transaction = new Transaction(LocalDate.now(), -amount, balance);
        transactions.add(transaction);
    }

    @Override
    public void printStatement() {
        System.out.printf("%-18s || %12s || %12s%n", "Date", "amount", "balance");

        // Print transactions in reverse chronological order (most recent first)
        List<Transaction> reversedTransactions = new ArrayList<>(transactions);
        Collections.reverse(reversedTransactions);

        for (Transaction transaction : reversedTransactions) {
            String formattedDate = transaction.date().format(dateFormatter);
            System.out.printf("%-18s || %12d || %12d%n",
                    formattedDate,
                    transaction.amount(),
                    transaction.balance());
        }
    }

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be positive. Provided: " + amount);
        }
    }

    public int getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    // Method to set date for testing (allows simulation of different dates)
    public void depositOnDate(int amount, LocalDate date) {
        validateAmount(amount);
        balance += amount;
        Transaction transaction = new Transaction(date, amount, balance);
        transactions.add(transaction);
    }

    public void withdrawOnDate(int amount, LocalDate date) {
        validateAmount(amount);
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Insufficient funds. Current balance: " + balance + ", Withdrawal amount: " + amount
            );
        }
        balance -= amount;
        Transaction transaction = new Transaction(date, -amount, balance);
        transactions.add(transaction);
    }
}
