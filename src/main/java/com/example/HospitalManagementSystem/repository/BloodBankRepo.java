package com.example.HospitalManagementSystem.repository;

import com.example.HospitalManagementSystem.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodBankRepo extends JpaRepository<Donation,Long> {
}
