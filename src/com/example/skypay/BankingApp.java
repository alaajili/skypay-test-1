package com.example.skypay;

import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        CommandProcessor commandProcessor = new CommandProcessor(account);

        UserInterface.displayWelcomeMessage();

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Thank you for using the Banking System!");
                break;
            }

            try {
                commandProcessor.processCommand(input);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        }

        scanner.close();
    }
}
