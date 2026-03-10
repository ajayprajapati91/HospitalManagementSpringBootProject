package com.example.HospitalManagementSystem.entity;

import com.example.HospitalManagementSystem.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloodRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bloodRequest_id")
    private Long bloodRequestId;
    private String bloodGroup;
    private Integer quantity;
    private LocalDateTime requestDate;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
