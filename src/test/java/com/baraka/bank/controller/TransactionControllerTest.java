package com.baraka.bank.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest()
public class TransactionControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void deposit_test()
    throws Exception {

        mockMvc.perform(get("/transaction/deposit"))
               .andExpect(status().isOk());
    }
    @Test
    public void withdraw_test()
    throws Exception {

        mockMvc.perform(get("/transaction/deposit"))
               .andExpect(status().isOk());
    }
    @Test
    public void transfer_test()
    throws Exception {

        mockMvc.perform(post("/transaction/transfer"))
               .andExpect(status().isOk());
    }
}
