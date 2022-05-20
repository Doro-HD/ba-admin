package com.coderbois.baadmin.controller;

import com.coderbois.baadmin.model.Lease;
import com.coderbois.baadmin.service.CarService;
import com.coderbois.baadmin.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

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
      public String createLease (HttpSession httpSession, Model model){
            String endpoint = "redirect:/login";
            Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");

            if (cookieUsername != null) {
                  endpoint = "leaseForm";

                  Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

                  model.addAttribute("username", cookieUsername.getValue());
                  model.addAttribute("userRole", cookieUserRole.getValue());

                  model.addAttribute("currentSite", "leaseForm");
                  model.addAttribute("lease", new Lease());
                  model.addAttribute("cars", carService.getAvailableCars());
            }

            return endpoint;
      }

      //Created by Victor
      @PostMapping("/leaseForm")
      public String createLeasePost (@ModelAttribute Lease lease){
            this.leaseService.saveLease(lease);

            return "redirect:/leaseForm";
      }
}
