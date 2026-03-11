package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.enums.BloodGroup;
import com.example.HospitalManagementSystem.proxy.responseProxy.BloodStockRespnseProxy;

import java.util.List;

public interface BloodStockService {

    String addBloodStock(BloodStockRespnseProxy bloodStockRespnseProxy);

    String updateBloodStock(BloodGroup bloodGroup, BloodStockRespnseProxy bloodStockRespnseProxy);

    BloodStockRespnseProxy getStockByBloodGroup(BloodGroup bloodGroup);

    List<BloodStockRespnseProxy> getAllBloodStock();

    boolean hasSufficientStock(BloodGroup bloodGroup, Integer requiredUnits);

    void reduceStock(BloodGroup bloodGroup, Integer unitsToDeduct);




}
