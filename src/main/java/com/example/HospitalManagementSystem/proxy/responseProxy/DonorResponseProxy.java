package com.example.HospitalManagementSystem.proxy.responseProxy;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonorResponseProxy {
    private Long donorId ;

    @NotBlank(message = "Blood group cannot be empty")
    @Pattern(regexp = "^(?:AB|A|B|O)[+-]$", message = "Invalid blood group format. Use format like 'A+' or 'O-'")
    private String  bloodGroup;

    @NotBlank(message = "Age is required")
    private Integer  age;

    @NotBlank(message = "Gender cannot be empty")
    private String gender;

    @NotBlank(message = "City cannot be empty")
    private String city;

    @NotNull(message = "Last Donation date cannot be null")
    private LocalDateTime lastDonationDate;

    @Pattern(regexp = "^(true|false)$",
            message = "Availability must be 'true' or 'false'")

    private String available;

    private Long usersId;
    private List<Long> donationId;


}
