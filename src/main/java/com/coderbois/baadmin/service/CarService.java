package com.coderbois.baadmin.service;

import com.coderbois.baadmin.model.Car;
import com.coderbois.baadmin.model.CarState;
import com.coderbois.baadmin.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//Authors
//Troels
//Victor
@Service
public class CarService {

      private final CarRepository carRepository;

      @Autowired
      public CarService(CarRepository carRepository){ // af Lasse
            this.carRepository = carRepository;
      }

      //Author
      //David
      public void createCar(Car car) {
            this.carRepository.createCar(car);
      }

      //Author
      //Lasse
      public ArrayList<Car> getAllCars(){ // af Lasse
            return carRepository.getAllCars();
      }

      //Author
      //Victor
      public ArrayList<Car> getAvailableCars(){
            ArrayList<Car> cars = this.carRepository.getAllCars();
            cars.removeIf(car -> car.getCarState() != CarState.AVAILABLE);

            return cars;
      }

      //Author
      //David
      //Troels
      public ArrayList<Car> getCheckUpCars(){
            ArrayList<Car> cars = this.carRepository.getAllCars();
            cars.removeIf(car -> car.getCarState() != CarState.CHECKUP);

            return cars;
      }

      public void updateCar(int carId, CarState carState){
            this.carRepository.updateCar(carId, carState);
      }




}
