package com.example.HospitalManagementSystem.service.implementation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReportingServiceImpl {
//    @Override
//    public BloodRequestResponseProxy createBloodRequest(BloodRequestRequestProxy bloodRequestRequestProxy) {
//        Optional<Hospital> hospitalOpt = hospitalRepo.findById(bloodRequestRequestProxy.getHospitalId());
//        if (hospitalOpt.isEmpty()) {
//            throw new UserNotFoundException("Hospital not found with id: " + bloodRequestRequestProxy.getHospitalId(), HttpStatus.NOT_FOUND.value());
//        }
//
//        Hospital hospital = hospitalOpt.get();
//
//        BloodRequest bloodRequest = BloodRequest.builder()
//                .bloodGroup(bloodRequestRequestProxy.getBloodGroup())
//                .quantity(bloodRequestRequestProxy.getQuantity())
//                .requestDate(LocalDateTime.now())
//                .status(StatusEnum.PENDING)
//                .hospital(hospital)
//                .build();
//
//        BloodRequest saved = bloodRequestRepo.save(bloodRequest);
//
//        return BloodRequestResponseProxy.builder()
//                .bloodRequestId(saved.getBloodRequestId())
//                .bloodGroup(saved.getBloodGroup())
//                .quantity(saved.getQuantity())
//                .requestDate(saved.getRequestDate())
//                .status(saved.getStatus())
//                .hospitalId(saved.getHospital().getHospitalId())
//                .build();
//    }
//
//    @Override
//    public BloodRequestResponseProxy processBloodRequest(Long bloodRequestId) {
//        Optional<BloodRequest> bloodRequestOpt = bloodRequestRepo.findById(bloodRequestId);
//        if (bloodRequestOpt.isEmpty()) {
//            throw new BloodRequestNotFoundException("Blood request not found with id: " + bloodRequestId, HttpStatus.NOT_FOUND.value());
//        }
//
//        BloodRequest bloodRequest = bloodRequestOpt.get();
//
//        // If already processed, just return current state
//        if (bloodRequest.getStatus() == StatusEnum.ACCEPTED || bloodRequest.getStatus() == StatusEnum.REJECTED) {
//            return BloodRequestResponseProxy.builder()
//                    .bloodRequestId(bloodRequest.getBloodRequestId())
//                    .bloodGroup(bloodRequest.getBloodGroup())
//                    .quantity(bloodRequest.getQuantity())
//                    .requestDate(bloodRequest.getRequestDate())
//                    .status(bloodRequest.getStatus())
//                    .hospitalId(bloodRequest.getHospital().getHospitalId())
//                    .build();
//        }
//
//        boolean sufficient = bloodStockService.hasSufficientStock(
//                bloodRequest.getBloodGroup(),
//                bloodRequest.getQuantity()
//        );
//
//        if (sufficient) {
//            bloodStockService.reduceStock(bloodRequest.getBloodGroup(), bloodRequest.getQuantity());
//            bloodRequest.setStatus(StatusEnum.ACCEPTED);
//        } else {
//            bloodRequest.setStatus(StatusEnum.REJECTED);
//        }
//
//        BloodRequest saved = bloodRequestRepo.save(bloodRequest);
//
//        return BloodRequestResponseProxy.builder()
//                .bloodRequestId(saved.getBloodRequestId())
//                .bloodGroup(saved.getBloodGroup())
//                .quantity(saved.getQuantity())
//                .requestDate(saved.getRequestDate())
//                .status(saved.getStatus())
//                .hospitalId(saved.getHospital().getHospitalId())
//                .build();
//    }
}
