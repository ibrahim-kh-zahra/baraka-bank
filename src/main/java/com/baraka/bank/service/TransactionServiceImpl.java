package com.baraka.bank.service;

import com.baraka.bank.exception.AccountNotFoundException;
import com.baraka.bank.exception.InsufficientBalanceException;
import com.baraka.bank.model.InternationalTransferData;
import com.baraka.bank.model.TransferData;
import com.baraka.bank.model.entities.Account;
import com.baraka.bank.model.DepositData;
import com.baraka.bank.model.WithdrawData;
import com.baraka.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
public class TransactionServiceImpl
    implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountService        accountService;

    @Override
    @Cacheable(cacheNames = "balance", key = "#data.accountId")

    @Transactional(readOnly = false,
                   isolation = Isolation.READ_COMMITTED)
    public boolean deposit(final DepositData data)
    throws AccountNotFoundException {

        Account account = accountService.findById(data.getAccountId());
        double updatedBalance = account.getBalance() + data.getAmount();
        transactionRepository.updateBalance(data.getAccountId(), updatedBalance);
        return true;
    }

    /**
     *
     * @param data
     * @return
     * @throws AccountNotFoundException
     * @throws InsufficientBalanceException
     */
    @Cacheable(cacheNames = "balance", key = "#data.accountId")
    @Transactional(readOnly = false,
                   isolation = Isolation.READ_COMMITTED)
    @Override
    public boolean withdraw(final WithdrawData data)
    throws AccountNotFoundException, InsufficientBalanceException {

        Account account = accountService.findById(data.getAccountId());
        if (account.getBalance() < data.getAmount()) {
            throw new InsufficientBalanceException();
        }
        double updatedBalance = account.getBalance() - data.getAmount();
        transactionRepository.updateBalance(data.getAccountId(), updatedBalance);
        return true;
    }

    /**
     *
     * @param data
     * @return
     * @throws AccountNotFoundException
     * @throws InsufficientBalanceException
     */
    @Transactional(readOnly = false,
                   isolation = Isolation.READ_COMMITTED)
    @Override
    public boolean transfer(final TransferData data)
    throws AccountNotFoundException, InsufficientBalanceException {

        Account account = accountService.findById(data.getFromAccountId());
        if (account.getBalance() < data.getAmount()) {
            throw new InsufficientBalanceException();
        }
        double updatedFromBalance = account.getBalance() - data.getAmount();
        double updatedToBalance = account.getBalance() + data.getAmount();

        transactionRepository.updateBalance(data.getFromAccountId(), updatedFromBalance);
        transactionRepository.updateBalance(data.getToAccountId(), updatedToBalance);

        return true;
    }

    /**
     *
     * @param data
     * @return
     */
    @Override
    public boolean transferInternational(final InternationalTransferData data) {
        //TODO
        //Call external API
        return false;
    }
}
