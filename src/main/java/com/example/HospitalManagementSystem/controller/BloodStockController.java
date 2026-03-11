package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.enums.BloodGroup;
import com.example.HospitalManagementSystem.proxy.responseProxy.BloodStockRespnseProxy;
import com.example.HospitalManagementSystem.repository.BloodStockRepo;
import com.example.HospitalManagementSystem.service.BloodStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class BloodStockController {

    @Autowired
    private BloodStockService bloodStockService;

    @PostMapping("/add-bloodStock")
    public ResponseEntity<String> addBloodStock(@RequestBody BloodStockRespnseProxy bloodStockRespnseProxy){
        return new ResponseEntity<>(bloodStockService.addBloodStock(bloodStockRespnseProxy), HttpStatus.CREATED);
    }

    @GetMapping("/get-byBloodGroup/{bloodGroup}")
    public ResponseEntity<BloodStockRespnseProxy> getBloodStockByBloodGroup(@PathVariable BloodGroup bloodGroup){
        return new ResponseEntity<>(bloodStockService.getStockByBloodGroup(bloodGroup),HttpStatus.OK);
    }

    @GetMapping("/get-allBloodStock")
    public ResponseEntity<List<BloodStockRespnseProxy>> getAllBloodStock(){
        return new ResponseEntity<>(bloodStockService.getAllBloodStock(),HttpStatus.OK);
    }
}
