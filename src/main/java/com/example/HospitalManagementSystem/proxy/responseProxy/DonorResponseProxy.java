package com.example.HospitalManagementSystem.proxy.responseProxy;

import com.example.HospitalManagementSystem.entity.Users;
import com.example.HospitalManagementSystem.enums.BloodGroup;
import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    private Integer  age;

    @NotBlank(message = "Gender cannot be empty")
    private String gender;

    @NotBlank(message = "City cannot be empty")
    private String city;

    @NotNull(message = "Last Donation date cannot be null")
    private LocalDateTime lastDonationDate;

    private Boolean available;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private Users users;
    private Long usersId;
    private List<Long> donationId;


}
