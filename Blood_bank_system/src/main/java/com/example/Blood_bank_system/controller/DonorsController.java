package com.example.Blood_bank_system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Blood_bank_system.Repository.DonorsRepository;
import com.example.Blood_bank_system.exception.ResourceNotFoundException;
import com.example.Blood_bank_system.model.Doners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:4200")
public class DonorsController {

    @Autowired
    public DonorsRepository donorsRepository;

    @GetMapping("/donor")
    public List<Doners> getAllDoners(){
        return donorsRepository.findAll();
    }
    @PostMapping("/donor")
    public Doners addDoner(@RequestBody Doners doners) {
        return donorsRepository.save(doners);
    }
    @GetMapping("/donor/{id}")
    public ResponseEntity<Doners> getUserById(@PathVariable Integer id){

        Doners doners = this.donorsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID not found"));
        return ResponseEntity.ok(doners);
    }
    @PutMapping("/donor/{id}")
    public ResponseEntity<Doners> updateDoner(@PathVariable Integer id, @RequestBody Doners doners){

        Doners doners1 = donorsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID not found"));

        doners1.setFullName(doners.getFullName());
        doners1.setDob(doners.getDob());
        doners1.setMarriageSts(doners.getMarriageSts());
        doners1.setProfile(doners.getProfile());
        doners1.setNationality(doners.getNationality());
        doners1.setPhone(doners.getPhone());
        doners1.setAction(doners.getAction());
        doners1.setVolunteer(doners.getVolunteer());
        doners1.setReplacement(doners.getReplacement());
        Doners updateDoner = donorsRepository.save(doners1);
        return ResponseEntity.ok(updateDoner);
    }
    @DeleteMapping("/donor/{id}")
    public ResponseEntity< Map<String,Boolean>> deleteDoner(@PathVariable Integer id){
        Doners doners = donorsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID not found"));

        donorsRepository.delete(doners);
        Map<String,Boolean> response= new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);

    }
}
