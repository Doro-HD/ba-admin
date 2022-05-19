package com.coderbois.baadmin.service;

import com.coderbois.baadmin.model.Lease;
import com.coderbois.baadmin.repository.LeaseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LeaseService {

    private final LeaseRepository leaseRepository;

    public LeaseService(LeaseRepository leaseRepository){
        this.leaseRepository = leaseRepository;
    }


    public void saveLease(Lease lease){
        this.leaseRepository.saveLease(lease);
    }


    public LeasingStatistic calculateBusinessInfo(){
        ArrayList<Lease> allLeases = this.leaseRepository.getAllLeases();
        double allAmount = 0;
        for (Lease lease: allLeases){
            allAmount = allAmount + lease.getMonthlyPay();
        }
        int countLease = allLeases.size();
        return (new LeasingStatistic(allLeases, allAmount, countLease));
    }

    }






