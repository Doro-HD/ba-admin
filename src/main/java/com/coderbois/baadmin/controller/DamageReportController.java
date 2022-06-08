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

//Authors
//David
//Troels
//Victor
@Controller
public class DamageReportController implements RoleProtected {

    private DamageReportService damageReportService;
    private CarService carService;

    @Autowired
    public DamageReportController(DamageReportService damageReportService, CarService carService) {
        this.damageReportService = damageReportService;
        this.carService = carService;
    }

    //Authors
    //David
    @GetMapping("/createDamageReport")
    public String createDamageReportGet(HttpSession httpSession, Model model) {
        String endpoint = "redirect:/login";
        Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");
        Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

        boolean userHasCorrectRole = this.hasCorrectRole(cookieUserRole.getValue());

        if (cookieUsername != null && userHasCorrectRole) {
            endpoint = "createDamageReport";


            model.addAttribute("username", cookieUsername.getValue());
            model.addAttribute("userRole", cookieUserRole.getValue());

            model.addAttribute("currentSite", "createDamageReport");

            model.addAttribute("damageReport", new DamageReport());
            model.addAttribute("checkUpCars", this.carService.getCheckUpCars());
        }


        return endpoint;
    }

    //Author
    //Troels
    @PostMapping("/createDamageReport")
    public String createDamageReportPost(@ModelAttribute DamageReport damageReport, HttpSession httpSession) {
        String endpoint = "redirect:/login";

        Cookie cookieUserName = (Cookie) httpSession.getAttribute("username");
        Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

        boolean userHasCorrectRole = this.hasCorrectRole(cookieUserRole.getValue());

        if (cookieUserName != null && userHasCorrectRole) {
            endpoint = "redirect:/createDamageReport";
            this.damageReportService.createDamageReport(damageReport);
        }


        return endpoint;
    }

    //Author
    //David
    @GetMapping("/allDamageReports")
    public String getAllReports(HttpSession httpSession, Model model) {
        String endpoint = "redirect:/login";
        Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");
        Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

        boolean userHasCorrectRole = this.hasCorrectRole(cookieUserRole.getValue());

        if (cookieUsername != null && userHasCorrectRole) {
            endpoint = "allDamageReports";


            model.addAttribute("username", cookieUsername.getValue());
            model.addAttribute("userRole", cookieUserRole.getValue());

            model.addAttribute("currentSite", "allDamageReports");

            model.addAttribute("damageReports", this.damageReportService.getAllDamageReports());
        }

        return endpoint;
    }

    //Author
    //David
    //Troels
    @GetMapping("/damageReport/{id}")
    public String damageReportGet(@PathVariable("id") int id, HttpSession httpSession, Model model) {
        String endpoint = "redirect:/login";
        Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");
        Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

        boolean userHasCorrectRole = this.hasCorrectRole(cookieUserRole.getValue());

        if (cookieUsername != null && userHasCorrectRole) {
            endpoint = "damageReport";


            model.addAttribute("username", cookieUsername.getValue());
            model.addAttribute("userRole", cookieUserRole.getValue());

            DamageReport damageReport = this.damageReportService.findDamageReportById(id);

            model.addAttribute("currentSite", "allDamageReports");

            model.addAttribute("damageReport", damageReport);
            model.addAttribute("damage", new Damage());
        }


        return endpoint;
    }

    //Author
    //David
    @PostMapping("/damageReport/{id}")
    public String createDamagePost(@PathVariable("id") int id, @ModelAttribute Damage damage, Model model, HttpSession httpSession) {
        String endpoint = "redirect:/login";

        Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");
        Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

        boolean userHasCorrectRole = this.hasCorrectRole(cookieUserRole.getValue());

        if (cookieUsername != null && userHasCorrectRole) {
            endpoint = "redirect:/damageReport/" + id;
            this.damageReportService.addDamageToDamageReport(id, damage);
            model.addAttribute("currentSite", "damageReport");

        }



        return endpoint;
    }

    //Author
    //David
    @GetMapping("/damageReportsPastWarningDate")
    public String damageReportsPastWarningDate(Model model, HttpSession httpSession) {
        String endpoint = "redirect:/login";
        Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");
        Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

        boolean userHasCorrectRole = this.hasCorrectRole(cookieUserRole.getValue());

        if (cookieUsername != null && userHasCorrectRole) {
            endpoint = "damageReportsPastWarningDate";


            model.addAttribute("username", cookieUsername.getValue());
            model.addAttribute("userRole", cookieUserRole.getValue());

            model.addAttribute("currentSite", "damageReportPastWarningDate");
            model.addAttribute("damageReports", this.damageReportService.findDamageReportPastWarningDate());
        }

        return endpoint;
    }

    @Override
    public boolean hasCorrectRole(String userRole) {
        return userRole.equals(Roles.DAMAGE_REPORT.getName());
    }
}
