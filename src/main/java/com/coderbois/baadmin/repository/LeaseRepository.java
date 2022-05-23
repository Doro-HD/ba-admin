package com.coderbois.baadmin.repository;


import com.coderbois.baadmin.model.Lease;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Repository
public class LeaseRepository {

    private final JdbcConnector jdbcConnector;

    public LeaseRepository (){
        this.jdbcConnector = new JdbcConnector();
    }

    // created by Lasse
    public ArrayList<Lease> getAllLeases (){
        ArrayList<Lease> allLeases = new ArrayList<>();
        try{
            String sql = "SELECT * FROM leases";
            ResultSet resultset = this.jdbcConnector.getStatement().executeQuery(sql);
            while(resultset.next()){
                int id = resultset.getInt("id");
                String leaseName = resultset.getString("lease_name");
                double monthlyPay = resultset.getDouble("monthly_payment");
                int carNumber = resultset.getInt("car_number");
                String localDate = resultset.getString("expiration_date");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                allLeases.add(new Lease(id, leaseName, monthlyPay, carNumber, LocalDate.parse(localDate, formatter)));
            }
        }catch (Exception e){
            System.out.println("something went wrong in getAllLeases");
            e.printStackTrace();
        }
        return allLeases;
    }


    // Create by Victor
    public void saveLease(Lease lease){
        try {
            PreparedStatement preparedStatement = this.jdbcConnector.getPreparedStatement("INSERT INTO leases(lease_name, monthly_payment, car_number, expiration_date) VALUES (?, ?, ?, ?)");
            System.out.println(lease.getLeaseName());
            preparedStatement.setString(1, lease.getLeaseName());
            preparedStatement.setDouble(2, lease.getMonthlyPay());
            preparedStatement.setInt(3, lease.getCarNumber());
            preparedStatement.setString(4, lease.getStringDate());

            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    // Create by Troels
    public ArrayList<Lease> getLeasesThatExpireByDate(String date){
        ArrayList<Lease> leases = new ArrayList<>();
        String sql = "SELECT * FROM leases WHERE expiration_date =  \"" + date + "\"";
        try{
            ResultSet resultSet = this.jdbcConnector.getStatement().executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String leaseName = resultSet.getString("lease_name");
                double monthlyPay = resultSet.getDouble("monthly_payment");
                int carNumber = resultSet.getInt("car_number");
                String localDate = resultSet.getString("expiration_date");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                leases.add(new Lease(id, leaseName, monthlyPay, carNumber, LocalDate.parse(localDate, formatter)));
            }
        }catch (SQLException e){
            System.out.println("Something went wrong in leasesBySearch");
            e.printStackTrace();
        }

        return leases;
    }
}
