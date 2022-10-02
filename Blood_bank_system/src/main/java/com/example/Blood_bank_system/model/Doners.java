package com.example.Blood_bank_system.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity

public class Doners {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String dob;
    private String marriageSts;
    private String nationality;
    private int phone;
    private String volunteer;
    private String action;
    private String replacement;
    private String profile;
}
