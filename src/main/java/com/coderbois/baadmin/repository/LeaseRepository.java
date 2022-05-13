package com.coderbois.baadmin.repository;


import com.coderbois.baadmin.model.Lease;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class LeaseRepository {

    private final JdbcConnector jdbcConnector;

    public LeaseRepository (){
        this.jdbcConnector = new JdbcConnector();
    }




    public void saveLease(Lease lease){
        try {
            PreparedStatement preparedStatement = this.jdbcConnector.getPreparedStatement("INSERT INTO leases(lease_name, monthly_payment, car_number) VALUES (?, ?, ?)");
            preparedStatement.setString(1, lease.getLeaseName());
            preparedStatement.setDouble(2, lease.getMonthlyPay());
            preparedStatement.setInt(3, lease.getCarNumber());

            preparedStatement.executeUpdate();



        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
