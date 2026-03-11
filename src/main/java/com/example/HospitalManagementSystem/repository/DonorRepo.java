package com.example.HospitalManagementSystem.repository;

import com.example.HospitalManagementSystem.entity.Donor;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonorRepo extends JpaRepository<Donor,Long> {
    Optional<Donor> findByUsersUsername(String username);
}
