package com.baraka.bank.exception;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(){
        System.out.println("Account not found");

    }
}
