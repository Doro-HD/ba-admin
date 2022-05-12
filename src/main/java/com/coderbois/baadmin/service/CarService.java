package com.coderbois.baadmin.service;

import com.coderbois.baadmin.model.Car;
import com.coderbois.baadmin.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarService {

      private final CarRepository carRepository;

      @Autowired
      public CarService(CarRepository carRepository){
            this.carRepository = carRepository;
      }

      public ArrayList<Car> getAllCars(){
            return carRepository.getAllCars();
      }

}
