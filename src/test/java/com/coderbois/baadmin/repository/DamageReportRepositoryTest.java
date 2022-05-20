package com.coderbois.baadmin.repository;

import com.coderbois.baadmin.model.Damage;
import com.coderbois.baadmin.model.DamageReport;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DamageReportRepositoryTest {

    //David
    @Test
    void createDamageReport() {
        DamageReportRepository damageReportRepository = new DamageReportRepository();

        DamageReport newDamageReport = new DamageReport();
        int carNumber = 1;
        newDamageReport.setCarNumber(carNumber);
        LocalDate localDate = LocalDate.now();
        localDate = localDate.plusWeeks(1);

        newDamageReport.setWarningDate(localDate);

        boolean reportWasSaved = damageReportRepository.createDamageReport(newDamageReport);

        assertTrue(reportWasSaved);
    }

    //David
    @Test
    void addDamageToDamageReport() {
        Damage damage = new Damage();
        damage.setDamageType("Ridse");
        damage.setPrice(100000000.0);

        DamageReportRepository damageReportRepository = new DamageReportRepository();
        boolean damageWasSaved = damageReportRepository.addDamageToDamageReport(1, damage);

        assertTrue(damageWasSaved);
    }

    @Test
    void findDamageReportPastWarningDate() {
        DamageReportRepository damageReportRepository = new DamageReportRepository();
        ArrayList<DamageReport> damageReports = damageReportRepository.findDamageReportPastWarningDate(LocalDate.now().toString());

        assertFalse(damageReports.isEmpty());
    }
}