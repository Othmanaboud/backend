package com.example.Blood_bank_system.controller;

import com.example.Blood_bank_system.Services.DonorRegistServices;
import com.example.Blood_bank_system.model.Donor_login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController


public class DonorRegistController {
    @Autowired
    public DonorRegistServices services;
    @PostMapping("/registdoner")
    @CrossOrigin(origins = "http://localhost:4200")
    public Donor_login registDonorUser(@RequestBody Donor_login donorlogin) throws Exception {
        String stampEmail= donorlogin.getEmail();
        if (stampEmail!=null && !"".equals(stampEmail));
         Donor_login donorLoginS=services.fetchDonorByEmail(stampEmail);
         if (donorLoginS !=null){
             throw new Exception("user already exist"+stampEmail+" with that id");
         }
        Donor_login DonorObjct=null;
        DonorObjct =services.saveDoner(donorlogin);
        return DonorObjct;
    }
    @PostMapping("/logindoner")
    @CrossOrigin(origins = "http://localhost:4200")
    public Donor_login loginDonerUser(@RequestBody Donor_login donor_login) throws Exception {
        String tempEmail = donor_login.getEmail();
        String tempPass = donor_login.getPassword();
        Donor_login donerObjct=null;
        if (tempEmail != null && tempPass != null) {
          donerObjct=  services.fetchDonorByEmailAndPassword(tempEmail, tempPass);
        }
        if(donerObjct == null){
            throw new Exception("bad cridentials");

        }
        return donerObjct;
    }

}
