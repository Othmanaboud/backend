package com.example.Blood_bank_system.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String blood_group;
    private String number_unit;
    private String unit_sent;
    private String unit_recieved;
    private String Epire_date;
    private Number total_unit;
}
