package com.baraka.bank.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountDto {
    private long userId;
    private Currency currency;
    private AccountType accountType;
}
