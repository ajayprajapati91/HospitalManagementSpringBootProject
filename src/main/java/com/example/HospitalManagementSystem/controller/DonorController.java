package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.proxy.responseProxy.DonorResponseProxy;
import com.example.HospitalManagementSystem.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donor")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @PostMapping("save-donor")
    public ResponseEntity<String> saveDonor(@RequestBody DonorResponseProxy donorResponseProxy) {
        return new ResponseEntity<>(donorService.saveDonor(donorResponseProxy),HttpStatus.CREATED);
    }

    @GetMapping("get-donor")
    public ResponseEntity<DonorResponseProxy> getDonor(@PathVariable Long donorId){
        return new ResponseEntity<>(donorService.getDonor(donorId),HttpStatus.OK);
    }


}



