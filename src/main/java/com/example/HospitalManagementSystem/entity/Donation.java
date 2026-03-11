package com.example.HospitalManagementSystem.entity;

import com.example.HospitalManagementSystem.enums.BloodGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donation_id")
    private Long donationId;
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
    private double unitsAvailable;
    private LocalDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private Donor donor;


}
