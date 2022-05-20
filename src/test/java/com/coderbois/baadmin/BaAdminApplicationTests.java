package com.coderbois.baadmin;

import com.coderbois.baadmin.model.Lease;
import com.coderbois.baadmin.repository.LeaseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLDataException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BaAdminApplicationTests {

    /*
    @Test
    void saveLeaseDoesNotThrowException() {
        LeaseRepository leaseRepository = new LeaseRepository();
        Lease testLease = new Lease("testLease", 500.0, 61);

        assertDoesNotThrow(SQLException, leaseRepository.saveLease(testLease));
    }

     */
}
