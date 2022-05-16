package com.coderbois.baadmin.controller;


import com.coderbois.baadmin.service.LeaseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@Controller
public class BusinessEngineeringController {
    private final LeaseService leaseService;

    public BusinessEngineeringController(LeaseService leaseService){
        this.leaseService = leaseService;
    }



    @GetMapping("/businessStats")
    public String getBusinessStatistic(Model model ){
        model.addAttribute("leasestatistic", this.leaseService.calculateBusinessInfo());
        return "businessStats";
    }

    @GetMapping("/")
    public String layout(){
        return "websitelayout";
    }




}
