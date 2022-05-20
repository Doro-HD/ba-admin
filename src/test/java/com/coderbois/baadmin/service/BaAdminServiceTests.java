package com.coderbois.baadmin.service;

import com.coderbois.baadmin.model.Lease;
import com.coderbois.baadmin.repository.LeaseRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaAdminServiceTests {


    @Test
    public void calculateBusinessInformationBasedOnLeases(){
        ArrayList<Lease> allLeases = new LeaseRepository().getAllLeases();

        double allAmount = 0;
        for (Lease lease: allLeases){
            allAmount = allAmount + lease.getMonthlyPay();
        }
        int countLease = allLeases.size();
        assertNotNull(new LeasingStatistic(allLeases, allAmount, countLease));
    }
}
