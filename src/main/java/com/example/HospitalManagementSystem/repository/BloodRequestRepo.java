package com.example.HospitalManagementSystem.repository;

import com.example.HospitalManagementSystem.entity.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRequestRepo extends JpaRepository<BloodRequest,Long> {
}
