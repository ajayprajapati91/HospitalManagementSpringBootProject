package com.example.HospitalManagementSystem.entity;

import com.example.HospitalManagementSystem.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String role;
    private String phoneNo;

    @Enumerated(EnumType.STRING)
    private StatusEnum Status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "donor_id")
    private Donor donor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "donation_id")
    private Donation donation;

}
