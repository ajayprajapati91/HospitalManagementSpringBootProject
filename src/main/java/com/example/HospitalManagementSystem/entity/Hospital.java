package com.example.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private Long hospitalId;
    private String hospitalName;
    private String email;
    private String password;
    private String address;
    private String contactNo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "donor_id")
    private List<Donor> donorList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Users> usersList;

    @OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL)
    private List<BloodRequest> bloodRequestList;

}
