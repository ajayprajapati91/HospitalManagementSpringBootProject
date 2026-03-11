package com.example.HospitalManagementSystem.proxy.responseProxy;

import com.example.HospitalManagementSystem.enums.BloodGroup;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
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
public class DonationResponseProxy {
    private Long donationId;

    @NotBlank(message = "Blood group cannot be empty")
    @Pattern(regexp = "^(?:AB|A|B|O)[+-]$", message = "Invalid blood group format. Use format like 'A+' or 'O-'")
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    private double unitsAvailable;
    private LocalDateTime lastUpdated;
}
