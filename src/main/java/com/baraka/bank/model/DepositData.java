package com.baraka.bank.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DepositData {
    private long accountId;
    private float amount;
}
