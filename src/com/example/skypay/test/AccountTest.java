package com.example.skypay.test;

public class AccountTest {
    public static void main(String[] args) {
        runAllTests();
    }

    public static void runAllTests() {
        System.out.println("Running Banking Service Tests...\n");

        BasicAccountTest.runTests();
        ExceptionHandlingTest.runTests();
        AcceptanceTest.runTests();
        StatementTest.runTests();

        System.out.println("All tests completed successfully!");
    }
}
