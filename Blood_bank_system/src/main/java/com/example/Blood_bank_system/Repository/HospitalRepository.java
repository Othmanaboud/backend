package com.example.Blood_bank_system.Repository;

import com.example.Blood_bank_system.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
}
