package com.baraka.bank.repository;

import com.baraka.bank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Query("update Account a set balance =:amount where a.id=:accountId ")
    public void updateBalance(long accountId,double amount);

}