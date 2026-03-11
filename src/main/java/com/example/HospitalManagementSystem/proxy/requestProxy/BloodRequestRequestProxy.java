package com.example.HospitalManagementSystem.proxy.requestProxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BloodRequestRequestProxy {
    private String bloodGroup;
    private Integer quantity;

    private Long hospitalId;
}
