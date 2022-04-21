package com.baraka.bank.exception;

public class InsufficientBalanceException
    extends Exception {

    public InsufficientBalanceException() {

        System.out.println("Insufficient balance for withdraw");
    }
}
