package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.proxy.requestProxy.HospitalRequestProxy;
import com.example.HospitalManagementSystem.proxy.responseProxy.HospitalResponseProxy;

public interface HospitalRequestSerivce {

    HospitalResponseProxy registerHospital(HospitalResponseProxy hospitalResponseProxy);

    HospitalResponseProxy getCurrentHospitalProfile();
}
