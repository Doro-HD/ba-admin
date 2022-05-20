package com.coderbois.baadmin.controller;


import com.coderbois.baadmin.model.Lease;
import com.coderbois.baadmin.service.LeaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String homePageGet(){
        return "index";
    }

    public String getLeasesThatExpireByDate(){

        return "";
    }


    @GetMapping("/searchdate")
    public String getCarsOnSpecificDate(Model model ){
        model.addAttribute("lease", new Lease());
        return "searchDate";
    }

    @GetMapping("/searchdate")
    public String postCarsOnSpecificDate(Model model ){

        return "businessStats";
    }


}
