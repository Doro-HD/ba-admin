package com.coderbois.baadmin.controller;

import com.coderbois.baadmin.model.CarState;
import com.coderbois.baadmin.model.Damage;
import com.coderbois.baadmin.model.DamageReport;
import com.coderbois.baadmin.service.CarService;
import com.coderbois.baadmin.service.DamageReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;

//Authors
//David
//Troels
//Victor
@Controller
public class DamageReportController {

    private DamageReportService damageReportService;
    private CarService carService;
    private RoleProtected roleProtected;

    @Autowired
    public DamageReportController(DamageReportService damageReportService, CarService carService) {
        this.damageReportService = damageReportService;
        this.carService = carService;
        this.roleProtected = new RoleProtected(Roles.DAMAGE_REPORT.getName());
    }

    //Authors
    //David
    @GetMapping("/createDamageReport")
    public String createDamageReportGet(HttpSession httpSession, Model model) {
        String endpoint = "redirect:/login";
        Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");
        Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

        boolean userHasCorrectRole = this.roleProtected.hasCorrectRole(cookieUserRole.getValue());

        if (cookieUsername != null && userHasCorrectRole) {
            endpoint = "createDamageReport";


            model.addAttribute("username", cookieUsername.getValue());
            model.addAttribute("userRole", cookieUserRole.getValue());

            model.addAttribute("currentSite", SidebarHighLighter.CREATE_DAMAGE_REPORT);

            model.addAttribute("damageReport", new DamageReport());
            model.addAttribute("checkUpCars", this.carService.getCheckUpCars());
        }


        return endpoint;
    }

    //Author
    //David
    //Troels
    @PostMapping("/createDamageReport")
    public String resolveCheckupCar(@ModelAttribute DamageReport damageReport, @RequestParam String action, HttpSession httpSession) {
        String endpoint = "redirect:/login";

        Cookie cookieUserName = (Cookie) httpSession.getAttribute("username");
        Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

        boolean userHasCorrectRole = this.roleProtected.hasCorrectRole(cookieUserRole.getValue());

        if (cookieUserName != null && userHasCorrectRole) {
            endpoint = "redirect:/createDamageReport";

            if (action.equals("available")) {
                this.carService.updateCar(damageReport.getCarNumber(), CarState.AVAILABLE);
            } else if (action.equals("damaged")) {
                this.damageReportService.createDamageReport(damageReport);
                this.carService.updateCar(damageReport.getCarNumber(), CarState.DAMAGED);
            }
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

        boolean userHasCorrectRole = this.roleProtected.hasCorrectRole(cookieUserRole.getValue());

        if (cookieUsername != null && userHasCorrectRole) {
            endpoint = "allDamageReports";


            model.addAttribute("username", cookieUsername.getValue());
            model.addAttribute("userRole", cookieUserRole.getValue());

            model.addAttribute("currentSite", SidebarHighLighter.ALL_DAMAGE_REPORTS);

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

        boolean userHasCorrectRole = this.roleProtected.hasCorrectRole(cookieUserRole.getValue());

        if (cookieUsername != null && userHasCorrectRole) {
            endpoint = "damageReport";


            model.addAttribute("username", cookieUsername.getValue());
            model.addAttribute("userRole", cookieUserRole.getValue());

            DamageReport damageReport = this.damageReportService.findDamageReportById(id);

            model.addAttribute("currentSite", SidebarHighLighter.ALL_DAMAGE_REPORTS);

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

        boolean userHasCorrectRole = this.roleProtected.hasCorrectRole(cookieUserRole.getValue());

        if (cookieUsername != null && userHasCorrectRole) {
            endpoint = "redirect:/damageReport/" + id;
            this.damageReportService.addDamageToDamageReport(id, damage);
        }



        return endpoint;
    }

    //Author
    //David
    //RequestParam fundet p?? nedenst??ende link den 08/06/22
    //https://stackoverflow.com/questions/8954426/spring-mvc-multiple-submit-button-to-a-form
    @PostMapping("/resolveDamageReport")
    public String resolveDamageReport(@RequestParam int damageReportId, HttpSession httpSession) {
        String endpoint = "redirect:/login";

        Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");
        Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

        boolean userHasCorrectRole = this.roleProtected.hasCorrectRole(cookieUserRole.getValue());

        if (cookieUsername != null && userHasCorrectRole) {
            endpoint = "redirect:/allDamageReports";

            DamageReport damageReport = this.damageReportService.findDamageReportById(damageReportId);

            this.carService.updateCar(damageReport.getCarNumber(), CarState.AVAILABLE);
            this.damageReportService.deleteDamageReportById(damageReportId);
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

        boolean userHasCorrectRole = this.roleProtected.hasCorrectRole(cookieUserRole.getValue());

        if (cookieUsername != null && userHasCorrectRole) {
            endpoint = "damageReportsPastWarningDate";


            model.addAttribute("username", cookieUsername.getValue());
            model.addAttribute("userRole", cookieUserRole.getValue());

            model.addAttribute("currentSite", SidebarHighLighter.DAMAGE_REPORTS_PAST_WARNING_DATE);
            model.addAttribute("damageReports", this.damageReportService.findDamageReportPastWarningDate());
        }

        return endpoint;
    }
}
