package com.example.HospitalManagementSystem.service.implementation;

import com.example.HospitalManagementSystem.entity.Users;
import com.example.HospitalManagementSystem.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> byUsername =  usersRepo.findByUsername(username);
        if(byUsername.isPresent()){
            Users users = byUsername.get();

            String roleString = users.getRole();
            String[] split = roleString.split(",");

            List<SimpleGrantedAuthority> list = Arrays.stream(split).map(r -> new SimpleGrantedAuthority(r)).toList();

            return User.builder()
                    .username(users.getUsername())
                    .password(users.getPassword())
                    .authorities(list)
                    .build();
        }
        throw new UsernameNotFoundException("Student not found"+username);
    }
}
