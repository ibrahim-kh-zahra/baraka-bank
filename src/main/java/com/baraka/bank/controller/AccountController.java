package com.baraka.bank.controller;

import com.baraka.bank.exception.AccountNotFoundException;
import com.baraka.bank.model.AccountDto;
import com.baraka.bank.model.entities.Account;
import com.baraka.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public Account create(@RequestBody
                              AccountDto account) {
        return accountService.createAccount(account);
    }

    @DeleteMapping
    public boolean delete(@RequestParam Long accountId) {
        return accountService.deleteAccount(accountId);
    }

    @GetMapping("/")
    public List<Account> getAccounts(@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10")
            Integer pageSize) {
        return accountService.findAll(pageNo, pageSize);
    }
    @GetMapping("/balance")
    public double getBalance(@RequestParam Long accountId)
    throws AccountNotFoundException {
        return accountService.getBalance(accountId);
    }
}
