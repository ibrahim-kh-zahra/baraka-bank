package com.baraka.bank.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest()
public class AccountControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get_available_balance_test()
    throws Exception {

        mockMvc.perform(get("/account/balance?accountId=1"))
               .andExpect(status().isOk());
    }
    @Test
    public void get_available_balance_missing_accountId_test()
    throws Exception {

        mockMvc.perform(get("/account/balance?"))
               .andExpect(status().is(500));
    }
    @Test
    public void get_all_accounts_list_test()
    throws Exception {

        mockMvc.perform(get("/account/"))
               .andExpect(status().isOk());
    }
}
