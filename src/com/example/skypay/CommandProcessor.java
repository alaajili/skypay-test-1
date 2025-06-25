package com.example.skypay;

import com.example.skypay.test.AccountTest;

public class CommandProcessor {
    private final Account account;

    public CommandProcessor(Account account) {
        this.account = account;
    }

    public void processCommand(String input) {
        String[] parts = input.split(" ");
        String command = parts[0];

        switch (command) {
            case "deposit" -> handleDeposit(parts);
            case "withdraw" -> handleWithdraw(parts);
            case "statement" -> handleStatement();
            case "balance" -> handleBalance();
            case "test" -> handleTest();
            case "help" -> handleHelp();
            default -> handleUnknownCommand(command);
        }
    }

    private void handleDeposit(String[] parts) {
        if (parts.length != 2) {
            System.out.println("Usage: deposit <amount>");
            return;
        }

        try {
            int amount = Integer.parseInt(parts[1]);
            account.deposit(amount);
            System.out.println("Successfully deposited " + amount + ". New balance: " + account.getBalance());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a valid number.");
        }
    }

    private void handleWithdraw(String[] parts) {
        if (parts.length != 2) {
            System.out.println("Usage: withdraw <amount>");
            return;
        }

        try {
            int amount = Integer.parseInt(parts[1]);
            account.withdraw(amount);
            System.out.println("Successfully withdrew " + amount + ". New balance: " + account.getBalance());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a valid number.");
        }
    }

    private void handleStatement() {
        System.out.println("Account Statement:");
        account.printStatement();
    }

    private void handleBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }

    private void handleTest() {
        System.out.println("Running automated tests...");
        AccountTest.runAllTests();
    }

    private void handleHelp() {
        System.out.println("==== Banking System Help ====");
        System.out.println("Available commands:");
        System.out.println("1. deposit <amount> - Deposit money into your account");
        System.out.println("2. withdraw <amount> - Withdraw money from your account");
        System.out.println("3. statement - Display your account statement");
        System.out.println("4. balance - Show your current account balance");
        System.out.println("5. test - Run automated tests");
        System.out.println("6. help - Display this help message");
        System.out.println("7. exit - Exit the banking application");
        System.out.println("=============================");
    }

    private void handleUnknownCommand(String command) {
        System.out.println("Unknown command: " + command);
        System.out.println("Type 'exit' to quit or use one of the available commands.");
    }
}
