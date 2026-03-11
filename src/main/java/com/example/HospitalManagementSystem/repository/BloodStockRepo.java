package com.example.HospitalManagementSystem.repository;

import com.example.HospitalManagementSystem.entity.BloodStock;
import com.example.HospitalManagementSystem.enums.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BloodStockRepo extends JpaRepository<BloodStock,Long> {
    Optional<BloodStock> findByBloodGroup(BloodGroup  bloodGroup);
}
