//package com.example.Blood_bank_system.controller;
//
//
//import com.example.Blood_bank_system.Repository.LaboratoryRepository;
//import com.example.Blood_bank_system.exception.ResourceNotFoundException;
//import com.example.Blood_bank_system.model.Laboratory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v2/")
//@CrossOrigin(origins="http://localhost:4200")
//public class LaboratoryController {
//
//    @Autowired
//    public LaboratoryRepository laboratoryRepository;
//
//    @GetMapping("/labo")
//    public List<Laboratory> getAllLab(){
//        return laboratoryRepository.findAll();
//    }
//    @PostMapping("/labo")
//    public Laboratory addLab(@RequestBody Laboratory laboratory) {
//        return laboratoryRepository.save(laboratory);
//    }
//    @GetMapping("/labo/{id}")
//    public ResponseEntity<Laboratory> getlabById(@PathVariable Integer id){
//
//        Laboratory laboratory = this.laboratoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID not found"));
//        return ResponseEntity.ok(laboratory);
//    }
//    @PutMapping("/labo/{id}")
//    public ResponseEntity<Laboratory> updateLab(@PathVariable Integer id, @RequestBody Laboratory laboratory){
//
//        Laboratory laboratory1 = laboratoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID not found"));
//
//        laboratory1.setBloodGroup(laboratory.getBloodGroup());
//        laboratory1.setCondition(laboratory.getCondition());
//        laboratory1.setZanId(laboratory.getZanId());
//        laboratory1.setDeseases(laboratory.getDeseases());
//        laboratory1.setText_area(laboratory.getText_area());
//        Laboratory updateLab = laboratoryRepository.save(laboratory1);
//        return ResponseEntity.ok(updateLab);
//    }
//    @DeleteMapping("/donor/{id}")
//    public ResponseEntity<Map<String,Boolean>> deleteHospital(@PathVariable Integer id){
//        Laboratory laboratory = laboratoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID not found"));
//        laboratoryRepository.delete(laboratory);
//        Map<String,Boolean> response= new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//
//        return ResponseEntity.ok(response);
//
//    }
//}
//
