package com.example.HospitalManagementSystem.service.implementation;

import com.example.HospitalManagementSystem.customizedException.DonorNotFoundException;
import com.example.HospitalManagementSystem.customizedException.UserNotFoundException;
import com.example.HospitalManagementSystem.entity.Donor;
import com.example.HospitalManagementSystem.entity.Users;
import com.example.HospitalManagementSystem.helper.MapperHelper;
import com.example.HospitalManagementSystem.proxy.responseProxy.DonorResponseProxy;
import com.example.HospitalManagementSystem.repository.DonorRepo;
import com.example.HospitalManagementSystem.repository.UsersRepo;
import com.example.HospitalManagementSystem.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class DonorServiceImpl implements DonorService {

    @Autowired
    private DonorRepo donorRepo;

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public String saveDonor(DonorResponseProxy donorResponseProxy) {
        Optional<Users> byId = usersRepo.findById(donorResponseProxy.getUsersId());
        if(byId.isEmpty()){
            throw new UserNotFoundException("user not found with id:"+byId, HttpStatus.NOT_FOUND.value());
        }
        Donor donor = mapperHelper.proxyToEntityDonor(donorResponseProxy);

        donor.setUsers(byId.get());
        donorRepo.save(donor);
        return "Donor is registered successfully";
    }

    @Override
    public DonorResponseProxy getDonor(Long donorId) {
        Optional<Donor> byId = donorRepo.findById(donorId);
        if (byId.isEmpty()){
            throw new DonorNotFoundException("Donor not found with this id :"+donorId,HttpStatus.NOT_FOUND.value());
        }
        Donor donor = byId.get();
        return mapperHelper.entityToProxyDonor(donor);
    }

    @Override
    public Boolean isEligible(DonorResponseProxy donorResponseProxy) {
        long donatedSinceMonths = ChronoUnit.MONTHS.between(donorResponseProxy.getLastDonationDate(), LocalDateTime.now());
        return donorResponseProxy.getAge() >=18 &&
                donorResponseProxy.getAge() <=65 &&
                donatedSinceMonths >=3;

    }

    @Override
    public DonorResponseProxy updateCurrentDonorProfile(Long donorId, DonorResponseProxy donorResponseProxy) {
        Optional<Donor> byId = donorRepo.findById(donorId);
        if (byId.isEmpty()){
            throw new DonorNotFoundException("Donor not found with this id :"+donorId,HttpStatus.NOT_FOUND.value());
        }
        Donor donor = byId.get();
        donor.setAge(donorResponseProxy.getAge());
        donor.setCity(donorResponseProxy.getCity());
        donor.setAvailable(donorResponseProxy.getAvailable());
        donor.setGender(donorResponseProxy.getGender());
        donor.setLastDonationDate(donorResponseProxy.getLastDonationDate());

        Users users = donor.getUsers();
        users.setName(donorResponseProxy.getUsers().getName());
        users.setEmail(donorResponseProxy.getUsers().getEmail());
        users.setRole(donorResponseProxy.getUsers().getRole());
        users.setPhoneNo(donorResponseProxy.getUsers().getPhoneNo());
        users.setStatus(donorResponseProxy.getUsers().getStatus());
        users.setUsername(donorResponseProxy.getUsers().getUsername());
        users.setPassword(donorResponseProxy.getUsers().getPassword());

        donor.setUsers(users);
        return mapperHelper.entityToProxyDonor(donorRepo.save(donor));
    }

    @Override
    public DonorResponseProxy getCurrentDonorProfile() {

        return null;
    }

    @Override
    public Boolean checkCurrentDonorEligibility() {
        return null;
    }

    @Override
    public String updateAvailability(Boolean available) {
        return "";
    }
}
