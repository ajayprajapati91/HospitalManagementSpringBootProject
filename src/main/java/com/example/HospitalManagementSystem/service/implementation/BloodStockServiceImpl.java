package com.example.HospitalManagementSystem.service.implementation;

import com.example.HospitalManagementSystem.customizedException.BloodStockNotFoundException;
import com.example.HospitalManagementSystem.entity.BloodStock;
import com.example.HospitalManagementSystem.enums.BloodGroup;
import com.example.HospitalManagementSystem.helper.MapperHelper;
import com.example.HospitalManagementSystem.proxy.responseProxy.BloodStockRespnseProxy;
import com.example.HospitalManagementSystem.repository.BloodStockRepo;
import com.example.HospitalManagementSystem.service.BloodStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BloodStockServiceImpl implements BloodStockService {

    @Autowired
    private BloodStockRepo bloodStockRepo;

    @Autowired
    private MapperHelper mapperHelper;

    @Override
    public String addBloodStock(BloodStockRespnseProxy bloodStockRespnseProxy) {
        BloodStock bloodStock = BloodStock.builder()
                .bloodGroup(bloodStockRespnseProxy.getBloodGroup())
                .unitsAvailable(bloodStockRespnseProxy.getUnitsAvailable())
                .lastUpdated(LocalDateTime.now())
                .build();

        bloodStockRepo.save(bloodStock);

        return "Blood stock added successfully for blood group "
                + bloodStockRespnseProxy.getBloodGroup();
    }

    @Override
    public String updateBloodStock(BloodGroup bloodGroup, BloodStockRespnseProxy bloodStockRespnseProxy) {

        BloodStock existingStock = bloodStockRepo.findByBloodGroup(bloodGroup)
                .orElseThrow(() -> new BloodStockNotFoundException(
                        "Blood stock not found for blood group " + bloodGroup,HttpStatus.NOT_FOUND.value()
                ));

        Integer newUnits = existingStock.getUnitsAvailable() + bloodStockRespnseProxy.getUnitsAvailable();

        existingStock.setUnitsAvailable(newUnits);
        existingStock.setLastUpdated(LocalDateTime.now());

        bloodStockRepo.save(existingStock);

        return "Blood stock updated successfully for blood group " + bloodGroup;
    }

    @Override
    public BloodStockRespnseProxy getStockByBloodGroup(BloodGroup bloodGroup) {
        Optional<BloodStock> byBloodGroup = bloodStockRepo.findByBloodGroup(bloodGroup);

        if(byBloodGroup.isEmpty()){
        throw new BloodStockNotFoundException("Blood stock not found for blood group " + bloodGroup,HttpStatus.NOT_FOUND.value());
        }
        return mapperHelper.entityToProxyBloodStock(byBloodGroup.get());
    }

    @Override
    public List<BloodStockRespnseProxy> getAllBloodStock() {
        List<BloodStock> bloodStockList = bloodStockRepo.findAll();
       return bloodStockList.stream().map(b->mapperHelper.entityToProxyBloodStock(b)).toList();
    }

    @Override
    public boolean hasSufficientStock(BloodGroup bloodGroup, Integer requiredUnits) {
        Optional<BloodStock> byBloodGroup = bloodStockRepo.findByBloodGroup(bloodGroup);
        if (byBloodGroup.isEmpty()) {
                return false;
            }
        return byBloodGroup.get().getUnitsAvailable() >= requiredUnits;
    }

    @Override
    public void reduceStock(BloodGroup bloodGroup, Integer unitsToDeduct) {
        Optional<BloodStock> byBloodGroup = bloodStockRepo.findByBloodGroup(bloodGroup);

        if (byBloodGroup.isEmpty()) {
            throw new BloodStockNotFoundException("Blood stock not found for blood group " + bloodGroup,HttpStatus.NOT_FOUND.value());
        }
        BloodStock bloodStock = byBloodGroup.get();
        Integer remaining = bloodStock.getUnitsAvailable() - unitsToDeduct;
        if (remaining < 0) {
            remaining = 0;
        }
        bloodStock.setUnitsAvailable(remaining);
        bloodStock.setLastUpdated(LocalDateTime.now());
        bloodStockRepo.save(bloodStock);
    }


}
