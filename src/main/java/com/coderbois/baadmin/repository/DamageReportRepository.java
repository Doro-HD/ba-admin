package com.coderbois.baadmin.repository;

import com.coderbois.baadmin.model.Damage;
import com.coderbois.baadmin.model.DamageReport;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//David
//Troels
@Repository
public class DamageReportRepository {

    private JdbcConnector jdbcConnector;

    //David
    public DamageReportRepository() {
        this.jdbcConnector = new JdbcConnector();
    }

    //Troels
    public boolean createDamageReport(DamageReport damageReport){
        boolean wasCreated = false;
        String SQL = "INSERT INTO damagereports (total_cost, car_id) VALUES (?,?)";
        PreparedStatement statement =jdbcConnector.getPreparedStatement(SQL);
        if(statement != null){
            try{
                statement.setDouble(1, 0);
                statement.setInt(2, damageReport.getCarNumber());
                statement.executeUpdate();
                wasCreated = true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return wasCreated;
    }

   //David
    public DamageReport findDamageReportByCarNumber(int carNumber){
        DamageReport dmReport = new DamageReport();
        Statement statement = this.jdbcConnector.getStatement();
        try {
            ResultSet damageReportResultSet = statement.executeQuery("SELECT * FROM damage_reports WHERE car_number = " + carNumber);
            while (damageReportResultSet.next()) {
                dmReport.setId(damageReportResultSet.getInt("id"));
                dmReport.setTotalCost(damageReportResultSet.getDouble("total_cost"));
                dmReport.setCarNumber(damageReportResultSet.getInt("car_id"));
            }

            ResultSet damagesResultSet = statement.executeQuery("SELECT * FROM damages WHERE damagereport_id = " + dmReport.getId());
            while (damagesResultSet.next()) {
                Damage damage = new Damage();
                damage.setDamageType(damagesResultSet.getString("damage_type"));
                damage.setPrice(damagesResultSet.getDouble("price"));

                dmReport.addDamage(damage);
            }
        } catch (SQLException e) {
            dmReport = null;
            e.printStackTrace();
        }

        return dmReport;
    }

    //David
    public DamageReport findDamageReportById(int id){
        DamageReport dmReport = new DamageReport();
        Statement statement = this.jdbcConnector.getStatement();
        try {
            ResultSet damageReportResultSet = statement.executeQuery("SELECT * FROM damage_reports WHERE car_number = " + id);
            while (damageReportResultSet.next()) {
                dmReport.setId(damageReportResultSet.getInt("id"));
                dmReport.setTotalCost(damageReportResultSet.getDouble("total_cost"));
                dmReport.setCarNumber(damageReportResultSet.getInt("car_id"));
            }

            ResultSet damagesResultSet = statement.executeQuery("SELECT * FROM damages WHERE damagereport_id = " + dmReport.getId());
            while (damagesResultSet.next()) {
                Damage damage = new Damage();
                damage.setDamageType(damagesResultSet.getString("damage_type"));
                damage.setPrice(damagesResultSet.getDouble("price"));

                dmReport.addDamage(damage);
            }
        } catch (SQLException e) {
            dmReport = null;
            e.printStackTrace();
        }

        return dmReport;
    }

    //David
    public boolean addDamageToDamageReport(int damageReportId , Damage damage){
        boolean wasDamageAdded = false;

        String sql = "UPDATE damages SET damage_type = ?, price = ? WHERE id = ?";
        PreparedStatement preparedStatement = this.jdbcConnector.getPreparedStatement(sql);

        if (preparedStatement != null) {
            try {
                preparedStatement.setString(1, damage.getDamageType());
                preparedStatement.setDouble(2, damage.getPrice());
                preparedStatement.setInt(3, damageReportId);

                preparedStatement.executeUpdate();
                wasDamageAdded = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return wasDamageAdded;
    }
}
