package com.example.Blood_bank_system.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Entity
public class Hospitalrequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String hospitalName;
    private String address;
    private String blood_Group;
    private String unit_Amount;
    private String text_Area;
}

