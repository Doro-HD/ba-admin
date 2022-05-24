package com.coderbois.baadmin.controller;


import com.coderbois.baadmin.model.Lease;
import com.coderbois.baadmin.service.CarService;
import com.coderbois.baadmin.service.LeaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

@Controller
public class BusinessEngineeringController {
      private final LeaseService leaseService;
      private final CarService carService;

      public BusinessEngineeringController(LeaseService leaseService, CarService carService) {
            this.leaseService = leaseService;
            this.carService = carService;
      }


      @GetMapping("/businessStats")
      public String getBusinessStatistic(HttpSession httpSession, Model model) {
            String endpoint = "redirect:/login";
            Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");

            if (cookieUsername != null) {
                  endpoint = "businessStats";

                  Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

                  model.addAttribute("username", cookieUsername.getValue());
                  model.addAttribute("userRole", cookieUserRole.getValue());

                  model.addAttribute("currentSite", "businessStats");
                  model.addAttribute("leasestatistic", this.leaseService.calculateBusinessInfo());
            }

            return endpoint;
      }

      @GetMapping("/")
      public String homePageGet(HttpSession httpSession, Model model) {
            String endpoint = "redirect:/login";
            Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");

            if (cookieUsername != null) {
                  endpoint = "index";

                  Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

                  model.addAttribute("username", cookieUsername.getValue());
                  model.addAttribute("userRole", cookieUserRole.getValue());

                  model.addAttribute("currentSite", "dashBoard");
            }


            return endpoint;
      }

      public String getLeasesThatExpireByDate() {

            return "";
      }


      @GetMapping("/searchDate")
      public String getCarsOnSpecificDate(Model model) {
            model.addAttribute("lease", new Lease());
            return "searchDate";
      }

      @PostMapping("/searchDate")
      public String postCarsOnSpecificDate(@ModelAttribute Lease lease, Model model) {
            model.addAttribute("leases", this.leaseService.getLeasesThatExpireByDate(lease));
            System.out.println(this.leaseService.getLeasesThatExpireByDate(lease));
            return "carByDate";
      }

      @GetMapping("/lagerbestand")
      public String checkWarehouse(HttpSession httpSession, Model model) {
            String endpoint = "redirect:/login";
            Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");

            if (cookieUsername != null) {
                  endpoint = "warehouse";

                  Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

                  model.addAttribute("allCars", carService.getAllCars());
                  model.addAttribute("username", cookieUsername.getValue());
                  model.addAttribute("userRole", cookieUserRole.getValue());

                  model.addAttribute("currentSite", "checkWarehouse");
            }


            return endpoint;
      }
}

