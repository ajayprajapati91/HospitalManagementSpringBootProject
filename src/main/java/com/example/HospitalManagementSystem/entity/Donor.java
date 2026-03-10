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
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donor_id")
    private Long donorId ;
  //  private Long userId;
    private String  bloodGroup;
    private Integer  age;
    private String gender;
    private String city;
    private LocalDateTime lastDonationDate;
    private Boolean available;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private Users users;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private List<Hospital> hospitalList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bloodBank_id")
    private List<Donation> donationList;
}
