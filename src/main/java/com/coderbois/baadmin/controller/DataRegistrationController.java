package com.coderbois.baadmin.controller;

import com.coderbois.baadmin.model.Car;
import com.coderbois.baadmin.model.Lease;
import com.coderbois.baadmin.service.CarService;
import com.coderbois.baadmin.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class DataRegistrationController {

      private final CarService carService;
      private final LeaseService leaseService;

      @Autowired
      public DataRegistrationController(CarService carService, LeaseService leaseService){
            this.carService = carService;
            this.leaseService = leaseService;
      }

      //Created by Lasse
      @GetMapping("/leaseForm")
      public String createLease (Model model){
            model.addAttribute("lease", new Lease());
            model.addAttribute("cars", carService.getAvailableCars());
            return "leaseForm";
      }

      //Created by Victor
      @PostMapping("/leaseForm")
      public String createLease (@ModelAttribute("lease") Lease lease){
            this.leaseService.saveLease(lease);

            return "redirect:/";
      }
}
