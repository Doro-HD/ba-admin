package com.coderbois.baadmin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BusinessEngineeringController {


    @GetMapping("/busistats")
    public String getBusinessStatistic(){

        return "businessStats";
    }


}
