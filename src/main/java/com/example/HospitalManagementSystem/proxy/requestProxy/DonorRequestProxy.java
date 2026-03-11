package com.example.HospitalManagementSystem.proxy.requestProxy;

import com.example.HospitalManagementSystem.enums.BloodGroup;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DonorRequestProxy {
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
    private UserRequestProxy user;
}
