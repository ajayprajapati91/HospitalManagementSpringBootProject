package com.example.HospitalManagementSystem.repository;

import com.example.HospitalManagementSystem.entity.BloodStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodStockRepo extends JpaRepository<BloodStock,Long> {
}
