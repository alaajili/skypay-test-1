package com.example.skypay.test;

import com.example.skypay.Account;

public class BasicAccountTest {

    public static void runTests() {
        testBasicDeposit();
        testBasicWithdrawal();
        testMultipleTransactions();
    }

    private static void testBasicDeposit() {
        System.out.println("Test: Basic Deposit");
        Account account = new Account();
        account.deposit(100);

        assert account.getBalance() == 100 : "Balance should be 100 after deposit";
        assert account.getTransactions().size() == 1 : "Should have 1 transaction";

        System.out.println("✓ Basic deposit test passed\n");
    }

    private static void testBasicWithdrawal() {
        System.out.println("Test: Basic Withdrawal");
        Account account = new Account();
        account.deposit(100);
        account.withdraw(50);

        assert account.getBalance() == 50 : "Balance should be 50 after withdrawal";
        assert account.getTransactions().size() == 2 : "Should have 2 transactions";

        System.out.println("✓ Basic withdrawal test passed\n");
    }

    private static void testMultipleTransactions() {
        System.out.println("Test: Multiple Transactions");
        Account account = new Account();

        // Perform multiple transactions
        account.deposit(1000);
        account.withdraw(200);
        account.deposit(500);
        account.withdraw(100);
        account.deposit(300);

        System.out.println("Multiple transactions statement:");
        account.printStatement();

        assert account.getBalance() == 1500 : "Final balance should be 1500";
        assert account.getTransactions().size() == 5 : "Should have 5 transactions";

        System.out.println("✓ Multiple transactions test passed\n");
    }
}
