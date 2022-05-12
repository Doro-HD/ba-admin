package com.coderbois.baadmin.repository;

import com.coderbois.baadmin.model.Damage;
import com.coderbois.baadmin.model.DamageReport;

import java.sql.PreparedStatement;

//Klasse oprettet af Troels.
//Tilføjet createDamageReport, findDamageReportByCarNumber, addDamageToDamageReport
public class DamageReportRepository {

    private JdbcConnector jdbcConnector;
    public DamageReportRepository() {
        this.jdbcConnector = new JdbcConnector();
    }

    public boolean createDamageReport(){
        return false;
    }

    public DamageReport findDamageReportByCarNumber(int number){
        DamageReport dmReport = new DamageReport();

        return dmReport;
    }

    public boolean addDamageToDamageReport(Damage damage){
        PreparedStatement preparedStatement =
        return false;
    }
}
