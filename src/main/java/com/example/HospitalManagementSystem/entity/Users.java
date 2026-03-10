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
    private String username;
    private String email;
    private String password;
    private String role;
    private String phoneNo;

    @Enumerated(EnumType.STRING)
    private StatusEnum Status;

    @OneToOne(mappedBy = "users")
    private Donor donorId;

    @OneToOne(mappedBy = "users")
    private Hospital hospitalId;

}
