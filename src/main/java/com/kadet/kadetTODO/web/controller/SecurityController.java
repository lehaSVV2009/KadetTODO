package com.kadet.kadetTODO.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class SecurityController {

    @RequestMapping("/login")
    public String login (Model model, @RequestParam(required = false) String message) {
        model.addAttribute("message", message);
        return "resources/security/login.html";
    }

    @RequestMapping(value = "/denied")
    public String denied () {
        return "resources/security/denied.html";
    }

    @RequestMapping(value = "/login/failure")
    public String loginFailure () {
        String message = "Login Failure!";
        return "redirect:/resources/login.html?message=" + message;
    }

    @RequestMapping(value = "/logout/success")
    public String logoutSuccess () {
        String message = "Logout Success!";
        return "redirect:/resources/login.html?message=" + message;
    }
}