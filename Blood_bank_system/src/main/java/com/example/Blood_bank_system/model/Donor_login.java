package com.example.Blood_bank_system.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Entity
public class Donor_login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int zanId;
    private String email;
    private String password;
    }



