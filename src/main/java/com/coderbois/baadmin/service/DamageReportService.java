package com.coderbois.baadmin.service;

import com.coderbois.baadmin.model.Damage;
import com.coderbois.baadmin.model.DamageReport;
import com.coderbois.baadmin.repository.DamageReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

//Authors
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

    //Author
    //David
    public ArrayList<DamageReport> getAllDamageReports() {
        return this.damageReportRepository.getAllDamageReports();
    }

    //Authors
    //Troels
    //David
    public boolean createDamageReport(DamageReport damageReport) {
        LocalDate now = LocalDate.now();
        LocalDate warningDate = now.plusWeeks(1);

        damageReport.setWarningDate(warningDate);

        return this.damageReportRepository.createDamageReport(damageReport);
    }

    //Author
    //Troels
    public DamageReport findDamageReportByCarNumber(int carNumber) {
        return this.damageReportRepository.findDamageReportByCarNumber(carNumber);
    }

    //Author
    //Troels
    public DamageReport findDamageReportById(int id) {
        return this.damageReportRepository.findDamageReportById(id);
    }

    //Author
    //Troels
    public boolean addDamageToDamageReport(int damageReportId, Damage damage) {
        return this.damageReportRepository.addDamageToDamageReport(damageReportId, damage);
    }

    //Author
    //David
    public ArrayList<DamageReport> findDamageReportPastWarningDate() {
        return this.damageReportRepository.findDamageReportPastWarningDate(LocalDate.now().toString());
    }

    //Author
    //David
    public void deleteDamageReportById(int id) {
        this.damageReportRepository.deleteDamageReportById(id);
    }
}
