package com.coderbois.baadmin.controller;

import com.coderbois.baadmin.model.Car;
import com.coderbois.baadmin.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class DataRegistrationController {

      private final CarService carService;

      @Autowired
      public DataRegistrationController(CarService carService){
            this.carService = carService;
      }

      @GetMapping("/findallcars")
      @ResponseBody
      public ArrayList<Car> getAllCars(){
            return carService.getAllCars();
      }




}
