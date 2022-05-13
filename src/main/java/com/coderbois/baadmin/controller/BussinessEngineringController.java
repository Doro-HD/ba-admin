package com.coderbois.baadmin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BussinessEngineringController {


    @GetMapping("/busstats")
    public String getBusinessStatistic(){

        return "businessstats";
    }


}
