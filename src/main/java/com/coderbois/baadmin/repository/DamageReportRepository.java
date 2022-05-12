package com.coderbois.baadmin.repository;

import com.coderbois.baadmin.model.Damage;
import com.coderbois.baadmin.model.DamageReport;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

//Klasse oprettet af Troels.
//Tilføjet createDamageReport, findDamageReportByCarNumber, addDamageToDamageReport

//David
//Troels
@Repository
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

    //David
    public boolean addDamageToDamageReport(int DamageReportId , Damage damage){
        boolean wasDamageAdded = false;
        String sql = "UPDATE damages SET damage_type = ?, price = ?";
        PreparedStatement preparedStatement = this.jdbcConnector.getPreparedStatement(sql);

        if (preparedStatement != null) {
            try {
                preparedStatement.setString(1, damage.getDamageType());
                preparedStatement.setDouble(2, damage.getPrice());

                preparedStatement.executeUpdate();
                wasDamageAdded = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return wasDamageAdded;
    }
}
