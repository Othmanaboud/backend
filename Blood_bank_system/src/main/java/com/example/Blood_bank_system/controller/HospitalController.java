package com.example.Blood_bank_system.controller;
import com.example.Blood_bank_system.Repository.HospitalRepository;
import com.example.Blood_bank_system.exception.ResourceNotFoundException;
import com.example.Blood_bank_system.model.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2/")
@CrossOrigin(origins="http://localhost:4200")
public class HospitalController {

    @Autowired
    public HospitalRepository hospitalRepository;

    @GetMapping("/hosp")
    public List<Hospital> getAllDoners(){
        return hospitalRepository.findAll();
    }
    @PostMapping("/hosp")
    public Hospital addHosp(@RequestBody Hospital hospital) {
        return hospitalRepository.save(hospital);
    }
    @GetMapping("/hosp/{id}")
    public ResponseEntity<Hospital> getUserById(@PathVariable Integer id){

        Hospital hospital = this.hospitalRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID not found"));
        return ResponseEntity.ok(hospital);
    }
    @PutMapping("/hosp/{id}")
    public ResponseEntity<Hospital> updateHosp(@PathVariable Integer id, @RequestBody Hospital hospital){

        Hospital hospital1 = hospitalRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID not found"));

        hospital1.setHospitalName(hospital.getHospitalName());
        hospital1.setAddress(hospital.getAddress());
        hospital1.setMembership(hospital.getMembership());
        hospital1.setEmail_Id(hospital.getEmail_Id());
        hospital1.setDate(hospital.getDate());
        Hospital updateHosp = hospitalRepository.save(hospital1);
        return ResponseEntity.ok(updateHosp);
     }
    @DeleteMapping("/donor/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteHospital(@PathVariable Integer id){
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID not found"));

        hospitalRepository.delete(hospital);
        Map<String,Boolean> response= new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);

    }
}

