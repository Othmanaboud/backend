package com.example.Blood_bank_system.Repository;


import com.example.Blood_bank_system.model.Doners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorsRepository extends JpaRepository<Doners,Integer> {


}

