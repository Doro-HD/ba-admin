package com.coderbois.baadmin.service;

import com.coderbois.baadmin.model.Damage;
import com.coderbois.baadmin.model.DamageReport;
import com.coderbois.baadmin.repository.DamageReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean createDamageReport(DamageReport damageReport) {
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
}
