package com.example.HospitalManagementSystem.repository;

import com.example.HospitalManagementSystem.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital,Long> {
}
