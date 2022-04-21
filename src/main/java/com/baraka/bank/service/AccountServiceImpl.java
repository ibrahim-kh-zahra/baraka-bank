package com.baraka.bank.service;

import com.baraka.bank.exception.AccountNotFoundException;
import com.baraka.bank.model.AccountDto;
import com.baraka.bank.model.entities.Account;
import com.baraka.bank.model.entities.User;
import com.baraka.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl
    implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserServiceImpl userService;

    @Override
    @Cacheable(cacheNames = "accounts",key = "#accountDto.accountId")
    public Account createAccount(final AccountDto accountDto) {
        User user=userService.findById(accountDto.getUserId());
        Account account=new Account();
        account.setAccountType(accountDto.getAccountType());
        account.setBalance(0);
        account.setUser(user);
        account.setCurrency(accountDto.getCurrency());
        return accountRepository.save(account);
    }

    @Override
    @Cacheable(cacheNames = "accounts",key = "#accountId")
    public boolean deleteAccount(final Long accountId) {

        accountRepository.deleteById(accountId);
        return true;
    }

    @Override
    @Cacheable(cacheNames = "account",key = "#accountId")
    public Account findById(final long accountId)
    throws AccountNotFoundException {
        System.out.println(accountId);
        Account account = accountRepository.findById(accountId)
                                           .get();
        if (account == null) {
            throw new AccountNotFoundException();
        }
        return account;
    }

    @Override
    @Cacheable(cacheNames = "accounts")
    public List<Account> findAll(int pageNumber, int pageSize) {

        Pageable paging = PageRequest.of(pageNumber, pageSize);
        Page<Account> pagedResult = accountRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Account>();
        }
    }

    @Override
    @Cacheable(cacheNames = "balance",key = "#accountId")
    public Double getBalance(final Long accountId)
    throws AccountNotFoundException {

        Optional<Account> account = accountRepository.findById(accountId);

        if (!account.isPresent()) {
            throw new AccountNotFoundException();
        }
        return account.get().getBalance();
    }
}
