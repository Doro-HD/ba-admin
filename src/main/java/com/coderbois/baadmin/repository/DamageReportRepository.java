package com.coderbois.baadmin.repository;

import com.coderbois.baadmin.model.Damage;
import com.coderbois.baadmin.model.DamageReport;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public boolean createDamageReport(DamageReport damageReport) {
        boolean wasCreated = false;
        String SQL = "INSERT INTO damagereports (total_cost, car_id) VALUES (?,?)";
        PreparedStatement statement = jdbcConnector.getPreparedStatement(SQL);
        if (statement != null) {
            try {
                statement.setDouble(1, 0);
                statement.setInt(2, damageReport.getCarNumber());
                statement.executeUpdate();
                wasCreated = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return wasCreated;
    }

    //David
    //Troels
    private ArrayList<DamageReport> getAllDamageReports(String sql) {
        ArrayList<DamageReport> damageReports = new ArrayList<>();

        Statement statement = this.jdbcConnector.getStatement();
        if (statement != null) {
            try {
                ResultSet damageReportResultSet = statement.executeQuery(sql);
                while (damageReportResultSet.next()) {
                    DamageReport damageReport = new DamageReport();

                    damageReport.setId(damageReportResultSet.getInt("id"));
                    damageReport.setTotalCost(damageReportResultSet.getDouble("total_cost"));
                    damageReport.setCarNumber(damageReportResultSet.getInt("car_id"));

                    ResultSet damagesResultSet = statement.executeQuery("SELECT * FROM damages WHERE damagereport_id = " + damageReport.getId());
                    while (damagesResultSet.next()) {
                        Damage damage = new Damage();
                        damage.setDamageType(damagesResultSet.getString("damage_type"));
                        damage.setPrice(damagesResultSet.getDouble("price"));

                        damageReport.addDamage(damage);
                    }

                    damageReports.add(damageReport);
                }
            } catch (SQLException e) {
                damageReports = null;
                e.printStackTrace();
            }

        } else {
            damageReports = null;
        }

        return damageReports;
    }

    //David
    public DamageReport findDamageReportByCarNumber(int carNumber) {
        DamageReport damageReport;
        ArrayList<DamageReport> damageReports = this.getAllDamageReports("SELECT * FROM damage_reports WHERE car_number = " + carNumber);

        if (damageReports == null || damageReports.size() < 1) {
            damageReport = null;
        } else {
            damageReport = damageReports.get(0);
        }

        return damageReport;
    }

    //David
    public DamageReport findDamageReportById(int id) {
        DamageReport damageReport;
        ArrayList<DamageReport> damageReports = this.getAllDamageReports("SELECT * FROM damage_reports WHERE id = " + id);

        if (damageReports == null || damageReports.size() < 1) {
            damageReport = null;
        } else {
            damageReport = damageReports.get(0);
        }

        return damageReport;
    }

    //David
    public boolean addDamageToDamageReport(int damageReportId, Damage damage) {
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
