package com.coderbois.baadmin.service;

import com.coderbois.baadmin.model.Damage;
import com.coderbois.baadmin.model.DamageReport;
import com.coderbois.baadmin.repository.DamageReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //Troels
    public boolean createDamageReport(int carNumber) {
        return this.damageReportRepository.createDamageReport(carNumber);
    }

    //Troels
    public DamageReport findDamageReportByCarNumber(int carNumber) {
        return this.damageReportRepository.findDamageReportByCarNumber(carNumber);
    }

    //Troels
    public boolean addDamageToDamageReport(int damageReportId, Damage damage) {
        return this.damageReportRepository.addDamageToDamageReport(damageReportId, damage);
    }
}
