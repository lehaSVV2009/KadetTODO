package com.kadet.kadetTODO.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping
    public String getHomePage () {
        return "resources/home.html";
    }

    @RequestMapping(value = "/home")
    public String getHomePageUrl () {
        return "resources/home.html";
    }

}
