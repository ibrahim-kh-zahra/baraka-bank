package com.baraka.bank.service;

import com.baraka.bank.exception.AccountNotFoundException;
import com.baraka.bank.exception.InsufficientBalanceException;
import com.baraka.bank.model.DepositData;
import com.baraka.bank.model.InternationalTransferData;
import com.baraka.bank.model.TransferData;
import com.baraka.bank.model.WithdrawData;

public interface TransactionService {
    public boolean  deposit(DepositData data)
    throws AccountNotFoundException;
    public boolean withdraw(WithdrawData data)
    throws AccountNotFoundException, InsufficientBalanceException;

    boolean transfer(TransferData data)
    throws AccountNotFoundException, InsufficientBalanceException;

    boolean transferInternational(InternationalTransferData data);
}
