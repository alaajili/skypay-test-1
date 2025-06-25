package com.example.skypay;

import java.time.LocalDate;

public record Transaction(LocalDate date, int amount, int balance) {
}
