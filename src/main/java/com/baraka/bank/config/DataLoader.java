package com.baraka.bank.config;

import com.baraka.bank.model.entities.User;
import com.baraka.bank.repository.AccountRepository;
import com.baraka.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader
    implements ApplicationRunner {

    private final UserRepository    userRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, AccountRepository accountRepository) {

        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    /**
     * Initial point for initializing DB with data from csv files
     * @param args
     */
    public void run(ApplicationArguments args) {

        System.out.println("Start loading data...");
        loadUser();
        loadAccount();

        System.out.println("Finish loading data...");
    }

    private void loadAccount() {


    }

    private void loadUser() {

    }
}