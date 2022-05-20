package com.coderbois.baadmin;

import com.coderbois.baadmin.model.Lease;
import com.coderbois.baadmin.repository.LeaseRepository;
import com.coderbois.baadmin.service.LeaseService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLDataException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BaAdminApplicationTests {

    /*
    @Test
    void saveLeaseAssertsTrue() {
        LeaseService leaseService = new LeaseService(new LeaseRepository());
        Lease testLease = new Lease("testLease", 500.0, 61, 5);

        assertTrue(leaseService.saveLease(testLease));
    }

     */
}
