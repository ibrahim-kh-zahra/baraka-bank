package com.baraka.bank.model.entities;

import com.baraka.bank.model.AccountType;
import com.baraka.bank.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String type;
    private double      balance;
    private AccountType accountType;
    private Currency    currency;
    private Date        lastUpdated;
    @ManyToOne
    private User user;

}
