package com.coderbois.baadmin.controller;


import com.coderbois.baadmin.service.LeaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

@Controller
public class BusinessEngineeringController {
    private final LeaseService leaseService;

    public BusinessEngineeringController(LeaseService leaseService){
        this.leaseService = leaseService;
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
    public String homePageGet(HttpSession httpSession, Model model){
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




}
