package com.coderbois.baadmin.service;

import com.coderbois.baadmin.model.Damage;
import com.coderbois.baadmin.model.DamageReport;
import com.coderbois.baadmin.repository.DamageReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

//David
//Troels
@Service
public class DamageReportService {

    private DamageReportRepository damageReportRepository;

    //David
    @Autowired
    public DamageReportService(DamageReportRepository damageReportRepository) {
        this.damageReportRepository = damageReportRepository;
    }

    //David
    public ArrayList<DamageReport> getAllDamageReports() {
        return this.damageReportRepository.getAllDamageReports();
    }

    //Troels
    //David
    public boolean createDamageReport(DamageReport damageReport) {
        LocalDate now = LocalDate.now();
        LocalDate warningDate = now.plusWeeks(1);

        damageReport.setWarningDate(warningDate);

        return this.damageReportRepository.createDamageReport(damageReport);
    }

    //Troels
    public DamageReport findDamageReportByCarNumber(int carNumber) {
        return this.damageReportRepository.findDamageReportByCarNumber(carNumber);
    }

    //Troels
    public DamageReport findDamageReportById(int id) {
        return this.damageReportRepository.findDamageReportById(id);
    }

    //Troels
    public boolean addDamageToDamageReport(int damageReportId, Damage damage) {
        return this.damageReportRepository.addDamageToDamageReport(damageReportId, damage);
    }

    //David
    public ArrayList<DamageReport> findDamageReportPastWarningDate() {
        return this.damageReportRepository.findDamageReportPastWarningDate(LocalDate.now().toString());
    }
}
