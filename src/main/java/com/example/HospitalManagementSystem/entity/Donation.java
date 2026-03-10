package com.example.HospitalManagementSystem.entity;

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
    @Column(name = "bloodBank_id")
    private Long donationId;
    private String bloodGroup;
    private double unitsAvailable;
    private LocalDateTime lastUpdated;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bloodStock_id")
    private List<BloodStock> bloodStockList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private List<Hospital> hospitalList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "donor_id")
    private List<Donor> donorList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bloodRequest_id")
    private List<BloodRequest> bloodRequestList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Users> usersList;


}
