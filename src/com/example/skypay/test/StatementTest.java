package com.example.skypay.test;

import com.example.skypay.Account;

public class StatementTest {

    public static void runTests() {
        testEmptyStatement();
    }

    private static void testEmptyStatement() {
        System.out.println("Test: Empty Statement");
        Account account = new Account();

        System.out.println("Empty account statement:");
        account.printStatement();

        assert account.getBalance() == 0 : "Balance should be 0";
        assert account.getTransactions().isEmpty() : "Should have no transactions";

        System.out.println("✓ Empty statement test passed\n");
    }
}
