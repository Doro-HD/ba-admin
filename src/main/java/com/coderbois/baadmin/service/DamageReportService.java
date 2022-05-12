package com.coderbois.baadmin.service;

import com.coderbois.baadmin.model.DamageReport;
import com.coderbois.baadmin.repository.DamageReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//David
@Service
public class DamageReportService {

    private DamageReportRepository damageReportRepository;

    @Autowired
    public DamageReportService(DamageReportRepository damageReportRepository) {
        this.damageReportRepository = damageReportRepository;
    }
    //David
    public boolean createDamageReport() {

    }

    //David
    public DamageReport findDamageReportByCarNumber() {

    }

    //David
    public boolean addDamageToDamageReport() {

    }
}
