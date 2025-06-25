package com.example.skypay.test;

import com.example.skypay.Account;
import com.example.skypay.exception.InsufficientFundsException;
import com.example.skypay.exception.InvalidAmountException;

public class ExceptionHandlingTest {

    public static void runTests() {
        testInsufficientFunds();
        testInvalidAmounts();
    }

    private static void testInsufficientFunds() {
        System.out.println("Test: Insufficient Funds");
        Account account = new Account();
        account.deposit(100);

        try {
            account.withdraw(150);
            assert false : "Should throw InsufficientFundsException";
        } catch (InsufficientFundsException e) {
            System.out.println("✓ Insufficient funds exception properly thrown: " + e.getMessage());
        }

        assert account.getBalance() == 100 : "Balance should remain unchanged after failed withdrawal";
        System.out.println("✓ Insufficient funds test passed\n");
    }

    private static void testInvalidAmounts() {
        System.out.println("Test: Invalid Amounts");
        Account account = new Account();

        try {
            account.deposit(0);
            assert false : "Should throw InvalidAmountException for zero deposit";
        } catch (InvalidAmountException e) {
            System.out.println("✓ Zero deposit exception: " + e.getMessage());
        }

        try {
            account.deposit(-100);
            assert false : "Should throw InvalidAmountException for negative deposit";
        } catch (InvalidAmountException e) {
            System.out.println("✓ Negative deposit exception: " + e.getMessage());
        }

        try {
            account.withdraw(-50);
            assert false : "Should throw InvalidAmountException for negative withdrawal";
        } catch (InvalidAmountException e) {
            System.out.println("✓ Negative withdrawal exception: " + e.getMessage());
        }

        System.out.println("✓ Invalid amounts test passed\n");
    }
}
