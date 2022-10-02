package com.example.Blood_bank_system.Repository;

import com.example.Blood_bank_system.model.Donor_login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRegistRepository extends JpaRepository<Donor_login,Integer> {
    public Donor_login findByEmail(String emailId);
    public Donor_login findByEmailAndPassword(String emailId,String password);

}
