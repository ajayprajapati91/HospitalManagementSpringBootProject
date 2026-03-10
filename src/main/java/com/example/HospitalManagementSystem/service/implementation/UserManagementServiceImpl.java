package com.example.HospitalManagementSystem.service.implementation;

import com.example.HospitalManagementSystem.entity.Users;
import com.example.HospitalManagementSystem.helper.MapperHelper;
import com.example.HospitalManagementSystem.model.AuthReq;
import com.example.HospitalManagementSystem.model.AuthResp;
import com.example.HospitalManagementSystem.proxy.responseProxy.UserResponseProxy;
import com.example.HospitalManagementSystem.repository.UsersRepo;
import com.example.HospitalManagementSystem.service.UserManagementService;
import com.example.HospitalManagementSystem.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    public String register(UserResponseProxy userResponseProxy) {
        Users users = mapperHelper.proxyToEntityUsers(userResponseProxy);
        usersRepo.save(users);
        return "User registered successfully";
    }

    @Override
    public AuthResp login(AuthReq authReq) {
        return null;
    }

    @Override
    public UserResponseProxy updateUser(Long id, UserResponseProxy userResponseProxy) {
        return null;
    }
    @Override
    public AuthResp authentication(AuthReq authReq) {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));
        if(authenticate.isAuthenticated()){
            UserDetails userDetails = myUserDetailsService.loadUserByUsername(authReq.getUsername());

            Date expiredOn = new Date();
            expiredOn.setTime(expiredOn.getTime()+1000*60*60*5);
            System.out.println("Expiry DateTime ->"+expiredOn);
            String jwtToken = jwtUtil.generateToken(userDetails,expiredOn);

            return AuthResp.builder()
                    .token(jwtToken)
                    .username(authReq.getUsername())
                    .expiredOn(expiredOn)
                    .build();
        }
        return null;
    }
}
