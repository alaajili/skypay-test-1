# SkyPay Test 1 - Banking System

A simple command-line banking application built in Java that allows users to manage their account with basic banking operations.

## Features

- **Deposit** - Add money to your account
- **Withdraw** - Remove money from your account (with insufficient funds protection)
- **Balance Check** - View current account balance
- **Statement** - Display transaction history in reverse chronological order
- **Built-in Testing** - Run automated tests to verify functionality

## Quick Start

1. Compile the Java files
2. Run the main class: `BankingApp`
3. Use the interactive commands to manage your account

## Available Commands

```
deposit <amount>    - Deposit money into your account
withdraw <amount>   - Withdraw money from your account
balance            - Show current account balance
statement          - Display account statement
test              - Run automated tests
help              - Show available commands
exit              - Exit the application
```

## Example Usage

```
Enter command: deposit 1000
Successfully deposited 1000. New balance: 1000

Enter command: withdraw 200
Successfully withdrew 200. New balance: 800

Enter command: statement
Account Statement:
Date               ||       amount ||      balance
25/06/2025         ||         -200 ||          800
25/06/2025         ||         1000 ||         1000
```

## Architecture

- **Account** - Core banking logic with transaction management
- **CommandProcessor** - Handles user input and command routing
- **Transaction** - Immutable record for transaction data
- **UserInterface** - Display utilities for user interaction

Built with proper error handling, input validation, and clean separation of concerns.