package com.example.HospitalManagementSystem.helper;

import com.example.HospitalManagementSystem.entity.*;
import com.example.HospitalManagementSystem.proxy.responseProxy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class MapperHelper {

    @Autowired
    private ObjectMapper objectMapper;

    public Donation proxyToEntityBloodBank(DonationResponseProxy donationResponseProxy){
        return objectMapper.convertValue(donationResponseProxy, Donation.class);
    }
    public DonationResponseProxy entityToProxyBloodBank(Donation donation){
        return objectMapper.convertValue(donation, DonationResponseProxy.class);
    }

    public BloodRequest proxyToEntityBloodRequest(BloodRequestResponseProxy bloodRequestResponseProxy){
        return objectMapper.convertValue(bloodRequestResponseProxy,BloodRequest.class);
    }
    public BloodRequestResponseProxy entityToProxyBloodRequest(BloodRequest bloodRequest){
        return objectMapper.convertValue(bloodRequest, BloodRequestResponseProxy.class);
    }

    public BloodStock proxyToEntityBloodStock(BloodStockRespnseProxy bloodStockRespnseProxy){
        return objectMapper.convertValue(bloodStockRespnseProxy,BloodStock.class);
    }
    public BloodStockRespnseProxy entityToProxyBloodStock(BloodStock bloodStock){
        return objectMapper.convertValue(bloodStock, BloodStockRespnseProxy.class);
    }

    public Donor proxyToEntityDonor(DonorResponseProxy donorResponseProxy){
        return objectMapper.convertValue(donorResponseProxy,Donor.class);
    }
    public DonorResponseProxy entityToProxyDonor(Donor donor){
        return objectMapper.convertValue(donor, DonorResponseProxy.class);
    }

    public Hospital proxyToEntityHospital(HospitalResponseProxy hospitalResponseProxy){
        return objectMapper.convertValue(hospitalResponseProxy,Hospital.class);
    }
    public HospitalResponseProxy entityToProxyHospital(Hospital hospital){
        return objectMapper.convertValue(hospital, HospitalResponseProxy.class);
    }

    public Users proxyToEntityUsers(UserResponseProxy userResponseProxy){
        return objectMapper.convertValue(userResponseProxy,Users.class);
    }
    public UserResponseProxy entityToProxyUsers(Users users){
        return objectMapper.convertValue(users, UserResponseProxy.class);
    }



}
