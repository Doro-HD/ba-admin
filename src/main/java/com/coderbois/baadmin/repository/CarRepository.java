package com.coderbois.baadmin.repository;

import com.coderbois.baadmin.model.Car;
import com.coderbois.baadmin.model.CarState;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class CarRepository {

      private final JdbcConnector jdbcConnector;

      public CarRepository (){ // af Lasse
            this.jdbcConnector = new JdbcConnector();
      }

      public ArrayList<Car> getAllCars (){ // af Lasse
            ArrayList<Car> allCars = new ArrayList<>();
            try{
                  String sql = "SELECT * FROM cars";
                  ResultSet resultSet = this.jdbcConnector.getStatement().executeQuery(sql);
                  while(resultSet.next()){
                        int id = resultSet.getInt("car_number");
                        String chassisNumber = resultSet.getString("chassis_number");
                        int carStateInt = resultSet.getInt("car_state");
                        CarState carState;
                        if(carStateInt == 1){
                              carState = CarState.AVAILABLE;
                        }
                        else if (carStateInt == 2){
                              carState = CarState.LEASED;
                        }
                        else if (carStateInt == 3) {
                              carState = CarState.DAMAGED;
                        } else{
                              carState = CarState.CHECKUP;
                        }
                        allCars.add(new Car(id, chassisNumber, carState));
                  }

            }catch(Exception e){
                  //Todo: remove when code is reliable
                  System.out.println("Something went wrong in getAllCars");
                  e.printStackTrace();
            }
            return allCars;
      }

}
