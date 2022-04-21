package com.baraka.bank.repository;

import com.baraka.bank.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account,Long> {}
