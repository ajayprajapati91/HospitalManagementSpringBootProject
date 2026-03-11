package com.example.HospitalManagementSystem.entity;

import com.example.HospitalManagementSystem.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "users_id")
    private Long usersId;
    private String name;
    private String username;
    private String email;
    private String password;
    private String role;
    private String phoneNo;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @JsonIgnore
    @OneToOne(mappedBy = "users",cascade = CascadeType.ALL)
    private Donor donorId;

    @JsonIgnore
    @OneToOne(mappedBy = "users")
    private Hospital hospitalId;

}
