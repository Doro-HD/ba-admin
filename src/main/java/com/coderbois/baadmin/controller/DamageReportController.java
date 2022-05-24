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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

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
    public String createDamageReportGet(HttpSession httpSession, Model model) {
        String endpoint = "redirect:/login";
        Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");

        if (cookieUsername != null) {
            endpoint = "createDamageReport";

            Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

            model.addAttribute("username", cookieUsername.getValue());
            model.addAttribute("userRole", cookieUserRole.getValue());

            model.addAttribute("currentSite", "createDamageReport");

            model.addAttribute("damageReport", new DamageReport());
            model.addAttribute("checkUpCars", this.carService.getCheckUpCars());
        }


        return endpoint;
    }

    //Troels
    @PostMapping("/createDamageReport")
    public String createDamageReportPost(@ModelAttribute DamageReport damageReport) {
        this.damageReportService.createDamageReport(damageReport);

        return "redirect:/createDamageReport";
    }

    //David
    @GetMapping("/allDamageReports")
    public String getAllReports(HttpSession httpSession, Model model) {
        String endpoint = "redirect:/login";
        Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");

        if (cookieUsername != null) {
            endpoint = "allDamageReports";

            Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

            model.addAttribute("username", cookieUsername.getValue());
            model.addAttribute("userRole", cookieUserRole.getValue());

            model.addAttribute("currentSite", "allDamageReports");

            model.addAttribute("damageReports", this.damageReportService.getAllDamageReports());
            model.addAttribute("numberOfDmg", this.damageReportService.getAllDamageReports().size());
        }

        return endpoint;
    }

    //David
    //Troels
    @GetMapping("/damageReport/{id}")
    public String damageReportGet(@PathVariable("id") int id, HttpSession httpSession, Model model) {
        String endpoint = "redirect:/login";
        Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");

        if (cookieUsername != null) {
            endpoint = "damageReport";

            Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

            model.addAttribute("username", cookieUsername.getValue());
            model.addAttribute("userRole", cookieUserRole.getValue());

            DamageReport damageReport = this.damageReportService.findDamageReportById(id);

            model.addAttribute("currentSite", "allDamageReports");

            model.addAttribute("damageReport", damageReport);
            model.addAttribute("damage", new Damage());
        }


        return endpoint;
    }

    //David
    @PostMapping("/damageReport/{id}")
    public String createDamagePost(@PathVariable("id") int id, @ModelAttribute Damage damage, Model model) {
        this.damageReportService.addDamageToDamageReport(id, damage);

        model.addAttribute("currentSite", "damageReport");

        return "redirect:/damageReport/" + id;
    }

    //Troels
    @GetMapping("/damageReportsPastWarningDate")
    public String damageReportsPastWarningDate(Model model, HttpSession httpSession) {
        String endpoint = "redirect:/login";
        Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");

        if (cookieUsername != null) {
            endpoint = "damageReportsPastWarningDate";

            Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

            model.addAttribute("username", cookieUsername.getValue());
            model.addAttribute("userRole", cookieUserRole.getValue());

            model.addAttribute("currentSite", "damageReportPastWarningDate");
            model.addAttribute("damageReports", this.damageReportService.findDamageReportPastWarningDate());
        }

        return endpoint;
    }
}
