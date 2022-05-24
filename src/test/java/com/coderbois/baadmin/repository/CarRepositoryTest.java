package com.coderbois.baadmin.repository;

import com.coderbois.baadmin.model.Car;
import com.coderbois.baadmin.model.CarState;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {

    @Test
    void createCar() {
        CarRepository carRepository = new CarRepository();

        Car car = new Car();
        car.setCarId(33);
        car.setChassisNumber("dæfjalsdfjæla");
        car.setCarState(CarState.AVAILABLE);

        carRepository.createCar(car);
    }
}