package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.proxy.responseProxy.DonorResponseProxy;
import tools.jackson.databind.node.StringNode;

public interface DonorService {

    String saveDonor(DonorResponseProxy donorResponseProxy);

    DonorResponseProxy getDonor(Long donorId);

    Boolean isEligible(DonorResponseProxy donorResponseProxy);

    DonorResponseProxy updateCurrentDonorProfile(Long donorId, DonorResponseProxy donorResponseProxy);

    DonorResponseProxy getCurrentDonorProfile();

    Boolean checkCurrentDonorEligibility();

    String updateAvailability(Boolean available);
}
