package com.coderbois.baadmin.repository;

import com.coderbois.baadmin.model.Car;
import com.coderbois.baadmin.model.CarState;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Authors
//David
//Lasse
@Repository
public class CarRepository {

      private final JdbcConnector jdbcConnector;

      public CarRepository (){ // af Lasse
            this.jdbcConnector = new JdbcConnector();
      }

      //Authors
      //David
      //Lasse
      public ArrayList<Car> getAllCars (){ // af Lasse
            ArrayList<Car> allCars = new ArrayList<>();
            try{
                  String sql = "SELECT * FROM cars";
                  ResultSet resultSet = this.jdbcConnector.getStatement().executeQuery(sql);
                  while(resultSet.next()){
                        Car car = new Car();

                        int id = resultSet.getInt("car_number");
                        String chassisNumber = resultSet.getString("chassis_number");
                        String carStateString = resultSet.getString("car_state");

                        CarState carState;

                        if (carStateString.equals(CarState.AVAILABLE.getName())) {
                              carState = CarState.AVAILABLE;
                        } else if (carStateString.equals(CarState.LEASED.getName())) {
                              carState = CarState.LEASED;
                        } else if (carStateString.equals(CarState.CHECKUP.getName())) {
                              carState = CarState.CHECKUP;
                        } else if (carStateString.equals(CarState.DAMAGED.getName())) {
                              carState = CarState.DAMAGED;
                        } else {
                              carState = null;
                        }

                        car.setCarId(id);
                        car.setChassisNumber(chassisNumber);
                        car.setCarState(carState);

                        allCars.add(car);
                  }

            }catch(Exception e){
                  //Todo: remove when code is reliable
                  System.out.println("Something went wrong in getAllCars");
                  e.printStackTrace();
            }

            return allCars;
      }

      //Author
      //David
      public void createCar(Car car) {
            PreparedStatement preparedStatement = this.jdbcConnector.getPreparedStatement("INSERT INTO cars (car_number, chassis_number, car_state) VALUES (?, ?, ?)");

            try {
                  preparedStatement.setInt(1, car.getCarId());
                  preparedStatement.setString(2, car.getChassisNumber());
                  preparedStatement.setString(3, car.getCarState().getName());

                  preparedStatement.executeUpdate();
            } catch (SQLException e) {
                  throw new RuntimeException(e);
            }
      }

}
