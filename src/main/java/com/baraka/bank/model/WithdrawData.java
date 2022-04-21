package com.baraka.bank.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class WithdrawData {
    private long accountId;
    private  double amount;
}
