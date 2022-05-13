package com.coderbois.baadmin.service;

import com.coderbois.baadmin.model.Lease;
import com.coderbois.baadmin.repository.LeaseRepository;
import org.springframework.stereotype.Service;

@Service
public class LeaseService {

    private final LeaseRepository leaseRepository;

    public LeaseService(LeaseRepository leaseRepository){
        this.leaseRepository = leaseRepository;
    }


    public void saveLease(Lease lease){
        this.leaseRepository.saveLease(lease);
    }

}
