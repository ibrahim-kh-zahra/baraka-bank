package com.baraka.bank.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferData {
    private long fromAccountId;
    private long toAccountId;
    private double amount;

}
