package com.example.HospitalManagementSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.support.SimpleTriggerContext;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthReq {
    private String username;
    private String password;
}
