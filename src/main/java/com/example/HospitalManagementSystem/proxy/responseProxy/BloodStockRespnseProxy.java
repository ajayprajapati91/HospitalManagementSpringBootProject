package com.example.HospitalManagementSystem.proxy.responseProxy;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloodStockRespnseProxy {
    private Long bloodStockId;

    @NotBlank(message = "Blood group cannot be empty")
    @Pattern(regexp = "^(?:AB|A|B|O)[+-]$", message = "Invalid blood group format. Use format like 'A+' or 'O-'")
    private String bloodGroup;

    @NotBlank(message = "Units available cannot be empty")
    @Pattern(regexp = "^\\d+$", message = "Units available must be a positive number")
    private String unitsAvailable;

    @NotNull(message = "Last updated date cannot be null")
    private LocalDateTime lastUpdated;
}
