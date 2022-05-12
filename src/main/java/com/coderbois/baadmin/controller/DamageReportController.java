package com.coderbois.baadmin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//David
public class DamageReportController {

    //David
    public String homePageGet() {
        return "";
    }

    //David
    @GetMapping("/createDamageReport")
    public String createDamageReportGet() {
        return "createDamageReport";
    }

    //David
    public String createDamageReportPost() {
        return "";
    }

    //David
    @GetMapping("/damageReport/{id}")
    public String damageReportGet(@PathVariable("id") int id) {

        return "damageReport";
    }

    //David
    public String createDamagePost() {
        return "";
    }
}
