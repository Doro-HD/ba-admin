package com.coderbois.baadmin.controller;

import com.coderbois.baadmin.model.Damage;
import com.coderbois.baadmin.model.DamageReport;
import com.coderbois.baadmin.service.CarService;
import com.coderbois.baadmin.service.DamageReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//David
@Controller
public class DamageReportController {

    private DamageReportService damageReportService;
    private CarService carService;

    @Autowired
    public DamageReportController(DamageReportService damageReportService, CarService carService) {
        this.damageReportService = damageReportService;
        this.carService = carService;
    }

    //David
    public String homePageGet() {
        return "";
    }

    //David
    @GetMapping("/createDamageReport")
    public String createDamageReportGet(Model model) {
        model.addAttribute("damageReport", new DamageReport());
        model.addAttribute("checkUpCars", this.carService.getCheckUpCars());

        return "createDamageReport";
    }

    //Troels
    @PostMapping("/createDamageReport")
    public String createDamageReportPost(@ModelAttribute DamageReport damageReport) {
        this.damageReportService.createDamageReport(damageReport);

        return "redirect:/createDamageReport";
    }

    //David
    @GetMapping("/damageReports")
    public String damageReportsGet(Model model) {
        model.addAttribute("damageReports", this.damageReportService.getAllDamageReports());
        return "allDamageReports";
    }

    //David
    //Troels
    @GetMapping("/damageReport/{id}")
    public String damageReportGet(@PathVariable("id") int id, Model model) {
        DamageReport damageReport = this.damageReportService.findDamageReportById(id);

        model.addAttribute("damageReport", damageReport);
        model.addAttribute("damage", new Damage());

        return "damageReport";
    }

    //David
    @PostMapping("/damageReport/{id}")
    public String createDamagePost(@PathVariable("id") int id, @ModelAttribute Damage damage) {
        this.damageReportService.addDamageToDamageReport(id, damage);

        return "redirect:/damageReport/" + id;
    }

    //Troels
    @GetMapping("/damageReportsPastWarningDate")
    public String damageReportsPastWarningDate(Model model){
        model.addAttribute("damageReports", this.damageReportService.findDamageReportPastWarningDate());

        return "damageReportsPastWarningDate";
    }
}
