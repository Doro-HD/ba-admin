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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

//Author
//David
//Lasse
//Victor
@Controller
public class DataRegistrationController implements RoleProtected {

      private final CarService carService;
      private final LeaseService leaseService;

      @Autowired
      public DataRegistrationController(CarService carService, LeaseService leaseService){
            this.carService = carService;
            this.leaseService = leaseService;
      }

      //Author
      //David
      @GetMapping("/createCar")
      public String createCar(HttpSession httpSession, Model model) {
            String endpoint = "redirect:/login";
            Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");
            Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

            boolean userHasCorrectRole = this.hasCorrectRole(cookieUserRole.getValue());

            if (cookieUsername != null && userHasCorrectRole) {
                  endpoint = "carForm";


                  model.addAttribute("username", cookieUsername.getValue());
                  model.addAttribute("userRole", cookieUserRole.getValue());

                  model.addAttribute("currentSite", "carForm");

                  model.addAttribute("car", new Car());
            }

            return endpoint;
      }

      //Author
      //David
      @PostMapping("createCar")
      public String createCarPost(@ModelAttribute Car car, HttpSession httpSession) {
            String endpoint = "redirect:/login";

            Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");
            Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

            boolean userHasCorrectRole = this.hasCorrectRole(cookieUserRole.getValue());

            if (cookieUsername != null && userHasCorrectRole) {
                  endpoint = "redirect:/createCar";
                  this.carService.createCar(car);

            }

            return endpoint;
      }


      //Authors
      //David
      //Lasse
      @GetMapping("/leaseForm")
      public String createLease (HttpSession httpSession, Model model){
            String endpoint = "redirect:/login";
            Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");
            Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

            boolean userHasCorrectRole = this.hasCorrectRole(cookieUserRole.getValue());

            if (cookieUsername != null && userHasCorrectRole) {
                  endpoint = "leaseForm";


                  model.addAttribute("username", cookieUsername.getValue());
                  model.addAttribute("userRole", cookieUserRole.getValue());

                  model.addAttribute("currentSite", "leaseForm");
                  model.addAttribute("lease", new Lease());
                  model.addAttribute("cars", carService.getAvailableCars());
            }

            return endpoint;
      }

      //Author
      //Victor
      @PostMapping("/leaseForm")
      public String createLeasePost (@ModelAttribute Lease lease, HttpSession httpSession){
            String endpoint = "redirect:/login";

            Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");
            Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

            boolean userHasCorrectRole = this.hasCorrectRole(cookieUserRole.getValue());

            if (cookieUsername != null && userHasCorrectRole) {
                  endpoint = "redirect:/leaseForm";
                  this.leaseService.saveLease(lease);

            }


            return endpoint;
      }

      //Authors
      //David
      //Lasse
      @GetMapping("/oldLease")
      public String showOldLeases (HttpSession httpSession, Model model) {
            String endpoint = "redirect:/login";
            Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");
            Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

            boolean userHasCorrectRole = this.hasCorrectRole(cookieUserRole.getValue());

            if (cookieUsername != null && userHasCorrectRole) {
                  endpoint = "oldLease";


                  model.addAttribute("username", cookieUsername.getValue());
                  model.addAttribute("userRole", cookieUserRole.getValue());
                  model.addAttribute("currentSite", "oldLease");

                  model.addAttribute("oldLease", leaseService.getLeasePastDueDate());
            }

            return endpoint;
      }

      //Author
      //David
      @Override
      public boolean hasCorrectRole(String userRole) {
            return userRole.equals(Roles.DATA_REGISTRATION.getName());
      }
}
