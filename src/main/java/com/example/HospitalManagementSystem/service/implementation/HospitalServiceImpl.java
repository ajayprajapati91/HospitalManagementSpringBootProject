package com.example.HospitalManagementSystem.service.implementation;

import com.example.HospitalManagementSystem.entity.Hospital;
import com.example.HospitalManagementSystem.entity.Users;
import com.example.HospitalManagementSystem.helper.MapperHelper;
import com.example.HospitalManagementSystem.proxy.responseProxy.HospitalResponseProxy;
import com.example.HospitalManagementSystem.service.HospitalRequestSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalRequestSerivce {

    @Autowired
    private MapperHelper mapperHelper;
    @Override
    public HospitalResponseProxy registerHospital(HospitalResponseProxy hospitalResponseProxy) {
         mapperHelper.proxyToEntityUsers(hospitalResponseProxy.getUsers());
        usersRepo.save(user);

        Hospital hospital = Hospital.builder()
                .hospitalName(requestProxy.getHospitalName())
                .users(user)
                .build();

        hospital = hospitalRepo.save(hospital);

        return mapperHelper.entityToProxyHospital(hospital);
    }

    @Override
    public HospitalResponseProxy getCurrentHospitalProfile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        Optional<Users> userOpt = usersRepo.findByUsername(username);
        if (userOpt.isEmpty()) {
            return null;
        }

        Users user = userOpt.get();

        Hospital hospital = hospitalRepo.findAll().stream()
                .filter(h -> h.getUsers() != null && h.getUsers().getUsersId().equals(user.getUsersId()))
                .findFirst()
                .orElse(null);

        if (hospital == null) {
            return null;
        }

        return mapperHelper.entityToProxyHospital(hospital);
    }
}
