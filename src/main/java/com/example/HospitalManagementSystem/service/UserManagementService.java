package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.entity.Users;
import com.example.HospitalManagementSystem.model.AuthReq;
import com.example.HospitalManagementSystem.model.AuthResp;
import com.example.HospitalManagementSystem.proxy.responseProxy.UserResponseProxy;

public interface UserManagementService {
    AuthResp authentication(AuthReq authReq);

    String register(UserResponseProxy userResponseProxy);

    AuthResp login(AuthReq authReq);

    UserResponseProxy updateUser(Long id, UserResponseProxy userResponseProxy);



}
