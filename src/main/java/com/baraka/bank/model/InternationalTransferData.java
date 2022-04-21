package com.baraka.bank.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InternationalTransferData {

    private long fromAccountId;
    private long toAccountId;
    private long swiftCode;
}
