package com.baraka.bank.controller;

import com.baraka.bank.exception.AccountNotFoundException;
import com.baraka.bank.exception.InsufficientBalanceException;
import com.baraka.bank.model.DepositData;
import com.baraka.bank.model.InternationalTransferData;
import com.baraka.bank.model.TransferData;
import com.baraka.bank.model.WithdrawData;
import com.baraka.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/deposit")
    public boolean deposit(@RequestBody DepositData data) throws AccountNotFoundException {
        return transactionService.deposit(data);
    }

    @PostMapping("/withdraw")
    public boolean withdraw(@RequestBody WithdrawData data) throws AccountNotFoundException, InsufficientBalanceException {
        return transactionService.withdraw(data);
    }

    @PostMapping("/transfer")
    public boolean transfer(@RequestBody TransferData data) throws AccountNotFoundException, InsufficientBalanceException {
        return transactionService.transfer(data);
    }

    @PostMapping("/transfer-international")
    public boolean transferInternational(
        @RequestBody InternationalTransferData data) throws AccountNotFoundException, InsufficientBalanceException {
        return transactionService.transferInternational(data);
    }
}
