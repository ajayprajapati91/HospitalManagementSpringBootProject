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
    private String  bloodGroup;
    private Integer  age;
    private String gender;
    private String city;
    private LocalDateTime lastDonationDate;
    private Boolean available;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private Users users;

    @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL)
    private List<Donation> donation;
}
