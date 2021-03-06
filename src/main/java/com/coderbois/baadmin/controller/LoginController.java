package com.coderbois.baadmin.controller;

import com.coderbois.baadmin.model.User;
import com.coderbois.baadmin.security.PasswordManager;

import com.coderbois.baadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

//Authors
//David
@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginGet(HttpSession httpSession, Model model) {
        String endpoint = "login";

        Cookie cookieUsername = (Cookie) httpSession.getAttribute("username");
        Cookie cookieUserRole = (Cookie) httpSession.getAttribute("role");

        if (cookieUsername != null && cookieUserRole != null) {
            endpoint = "index";
            model.addAttribute("currentSite", "dashBoard");
            model.addAttribute("userRole", cookieUserRole.getValue());
        } else {
            model.addAttribute("user", new User());
        }

        return endpoint;
    }

    //Author
    //David
    @PostMapping("/login")
    public String loginPost(@ModelAttribute User userAttemptingToLogin, HttpSession httpSession){
        String endpoint = "/login";
        boolean passwordIsCorrect = false;
        PasswordManager passwordManager = new PasswordManager();

        User user = this.userService.findUserByUsername(userAttemptingToLogin.getUsername());

        if (user != null) {
            passwordIsCorrect = passwordManager.validatePassword(userAttemptingToLogin.getPassword(), user.getPassword());
        }

        if (passwordIsCorrect) {
            Cookie cookieUsername = new Cookie("username", user.getUsername());
            Cookie cookieRole = new Cookie("role", user.getRole());

            httpSession.setAttribute("username", cookieUsername);
            httpSession.setAttribute("role", cookieRole);

            endpoint = "/";
        }

        return "redirect:" + endpoint;
    }

    //Author
    //David
    @GetMapping("/logout")
    public String logoutPost(HttpSession httpSession){
        httpSession.invalidate();

        return "redirect:/login";
    }
}

