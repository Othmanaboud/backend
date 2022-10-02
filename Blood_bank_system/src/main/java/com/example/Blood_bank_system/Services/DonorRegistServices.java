package com.example.Blood_bank_system.Services;

import com.example.Blood_bank_system.Repository.DonorRegistRepository;
import com.example.Blood_bank_system.model.Donor_login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DonorRegistServices {
    @Autowired
    public DonorRegistRepository repo;

    public Donor_login saveDoner(Donor_login donorlogin) {

        return repo.save(donorlogin);
    }

    public Donor_login fetchDonorByEmail(String email) {
        return repo.findByEmail(email);

    }

    public Donor_login fetchDonorByEmailAndPassword(String emailId, String password) {
        return repo.findByEmailAndPassword(emailId, password);
    }
}