package com.example.HospitalManagementSystem.service.implementation;

import com.interns.SpringSecuritydemo.domain.Student;
import com.interns.SpringSecuritydemo.repo.StudentRepo;
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
    private StudentRepo stdRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Student> byUsername =  stdRepo.findByUsername(username);
        if(byUsername.isPresent()){
            Student student = byUsername.get();

            String roleString = student.getRoles();
            String[] split = roleString.split(",");

            List<SimpleGrantedAuthority> list = Arrays.stream(split).map(r -> new SimpleGrantedAuthority(r)).toList();

            return User.builder()
                    .username(student.getUsername())
                    .password(student.getPassword())
                    .authorities(list)
                    .build();
        }
        throw new UsernameNotFoundException("Student not found"+username);
    }
}
