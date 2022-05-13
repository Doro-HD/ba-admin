package com.coderbois.baadmin;

import com.coderbois.baadmin.model.Lease;
import com.coderbois.baadmin.repository.CarRepository;
import com.coderbois.baadmin.repository.LeaseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BaAdminApplicationTests {

    /* Lasse - Vil gerne teste at den ikke smider en exception når man smider et lease object til metoden,
    men kan ikke lige gennemskue formalia....
    @Test
    void saveLeaseDoesNotThrowException() {
        LeaseRepository leaseRepository = new LeaseRepository();
        Lease testLease = new Lease("testLease", 500.0, 61);

        assertDoesNotThrow(Exception(), leaseRepository.saveLease(testLease));
    }

    */
}
