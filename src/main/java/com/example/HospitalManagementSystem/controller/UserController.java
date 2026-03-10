package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.entity.Users;
import com.example.HospitalManagementSystem.model.AuthReq;
import com.example.HospitalManagementSystem.model.AuthResp;
import com.example.HospitalManagementSystem.proxy.responseProxy.UserResponseProxy;
import com.example.HospitalManagementSystem.service.UserManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserResponseProxy userResponseProxy){
        return new ResponseEntity<>(userManagementService.register(userResponseProxy), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResp> login(@Valid @RequestBody AuthReq authReq){
        return new ResponseEntity<>(userManagementService.authenticate(authReq),HttpStatus.OK);
    }
}
