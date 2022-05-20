package com.coderbois.baadmin.repository;

import com.coderbois.baadmin.model.Damage;
import com.coderbois.baadmin.model.DamageReport;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
        String SQL = "INSERT INTO damage_reports (total_cost, car_number, warning_date) VALUES (?,?,?)";
        PreparedStatement statement = jdbcConnector.getPreparedStatement(SQL);
        if (statement != null) {
            try {
                statement.setDouble(1, 0);
                statement.setInt(2, damageReport.getCarNumber());
                statement.setString(3, damageReport.getWarningDateAsString());
                statement.executeUpdate();
                wasCreated = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return wasCreated;
    }

    //David
    //Troels
    private ArrayList<DamageReport> getAllDamageReports(String sql) {
        ArrayList<DamageReport> damageReports = new ArrayList<>();

        Statement damageReportStatement = this.jdbcConnector.getStatement();
        Statement damageStatement = this.jdbcConnector.getStatement();
        if (damageReportStatement != null && damageStatement != null) {
            try {
                ResultSet damageReportResultSet = damageReportStatement.executeQuery(sql);
                while (damageReportResultSet.next()) {
                    DamageReport damageReport = new DamageReport();

                    damageReport.setId(damageReportResultSet.getInt("id"));
                    damageReport.setTotalCost(damageReportResultSet.getDouble("total_cost"));
                    damageReport.setCarNumber(damageReportResultSet.getInt("car_number"));

                    String date = damageReportResultSet.getString("warning_date");
                    damageReport.setWarningDate(LocalDate.parse(date));

                    ResultSet damagesResultSet = damageStatement.executeQuery("SELECT * FROM damages WHERE damage_report_id = " + damageReport.getId());
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
    public ArrayList<DamageReport> getAllDamageReports() {
        return this.getAllDamageReports("SELECT * FROM damage_reports");
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
    public ArrayList<DamageReport> findDamageReportPastWarningDate(String date) {
        return this.getAllDamageReports("SELECT * FROM damage_reports WHERE warning_date <= \"" + date + "\" ORDER BY warning_date ASC");
    }

    //David
    public boolean addDamageToDamageReport(int damageReportId, Damage damage) {
        boolean wasDamageAdded = false;

        String sql = "INSERT INTO damages (damage_type, price, damage_report_id) VALUES (?, ?, ?)";
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
