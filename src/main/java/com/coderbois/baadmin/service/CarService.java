package com.coderbois.baadmin.service;

import com.coderbois.baadmin.model.Car;
import com.coderbois.baadmin.model.CarState;
import com.coderbois.baadmin.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarService {

      private final CarRepository carRepository;

      @Autowired
      public CarService(CarRepository carRepository){ // af Lasse
            this.carRepository = carRepository;
      }

      public ArrayList<Car> getAllCars(){ // af Lasse
            return carRepository.getAllCars();
      }



      //Created by Victor
      public ArrayList<Car> getAvailableCars(){
            ArrayList<Car> cars = this.carRepository.getAllCars();
            cars.removeIf(car -> car.getCarState() != CarState.AVAILABLE);
            return cars;


      }



}
