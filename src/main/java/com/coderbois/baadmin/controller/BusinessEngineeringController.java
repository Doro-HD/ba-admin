package com.coderbois.baadmin.controller;


import com.coderbois.baadmin.model.Lease;
import com.coderbois.baadmin.service.LeaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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


    @GetMapping("/searchDate")
    public String getCarsOnSpecificDate(Model model ){
        model.addAttribute("lease", new Lease());
        return "searchDate";
    }

    @PostMapping("/searchDate")
    public String postCarsOnSpecificDate(@ModelAttribute Lease lease, Model model){
        model.addAttribute("leases", this.leaseService.getLeasesThatExpireByDate(lease));
        System.out.println(this.leaseService.getLeasesThatExpireByDate(lease));
        return "carByDate";
    }


}
