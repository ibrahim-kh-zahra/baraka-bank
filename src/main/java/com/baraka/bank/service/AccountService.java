package com.baraka.bank.service;

import com.baraka.bank.exception.AccountNotFoundException;
import com.baraka.bank.model.AccountDto;
import com.baraka.bank.model.entities.Account;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {
    public Account createAccount(AccountDto account);

    public boolean deleteAccount(Long accountId);
    public Account findById(long accountId) throws AccountNotFoundException;
    public List<Account>findAll(int pageNumber,int pageSize);

    Double getBalance(Long accountId)
    throws AccountNotFoundException;
}
