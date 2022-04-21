package com.baraka.bank.model.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Setter
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long   id;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private String password;
    private String email;
}
