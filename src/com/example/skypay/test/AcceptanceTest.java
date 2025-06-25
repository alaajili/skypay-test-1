package com.example.skypay.test;

import com.example.skypay.Account;
import java.time.LocalDate;

public class AcceptanceTest {

    public static void runTests() {
        testAcceptanceScenario();
    }

    private static void testAcceptanceScenario() {
        System.out.println("Test: Acceptance Scenario");
        Account account = new Account();

        // Given a client makes a deposit of 1000 on 10-01-2012
        account.depositOnDate(1000, LocalDate.of(2012, 1, 10));

        // And a deposit of 2000 on 13-01-2012
        account.depositOnDate(2000, LocalDate.of(2012, 1, 13));

        // And a withdrawal of 500 on 14-01-2012
        account.withdrawOnDate(500, LocalDate.of(2012, 1, 14));

        // When they print their bank statement
        System.out.println("Expected output:");
        System.out.printf("%-18s || %12s || %12s%n", "Date", "amount", "balance");
        System.out.printf("%-18s || %12d || %12d%n", "14/01/2012", -500, 2500);
        System.out.printf("%-18s || %12d || %12d%n", "13/01/2012", 2000, 3000);
        System.out.printf("%-18s || %12d || %12d%n", "10/01/2012", 1000, 1000);

        System.out.println("\nActual output:");
        account.printStatement();

        assert account.getBalance() == 2500 : "Final balance should be 2500";
        assert account.getTransactions().size() == 3 : "Should have 3 transactions";

        System.out.println("✓ Acceptance scenario test passed\n");
    }
}
