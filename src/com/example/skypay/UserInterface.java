package com.example.skypay;

public class UserInterface {

    public static void displayWelcomeMessage() {
        System.out.println("==== Welcome to the Banking System ====");
        System.out.println("Available commands:");
        System.out.println("1. deposit <amount> - Deposit money");
        System.out.println("2. withdraw <amount> - Withdraw money");
        System.out.println("3. statement - Print account statement");
        System.out.println("4. balance - Show current balance");
        System.out.println("5. test - Run automated tests");
        System.out.println("6. help - Display this help message");
        System.out.println("7. exit - Exit the application");
        System.out.println("=======================================\n");
    }
}
