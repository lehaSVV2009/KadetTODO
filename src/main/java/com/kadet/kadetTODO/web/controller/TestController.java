package com.kadet.kadetTODO.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Date: 11.11.2014
 * Time: 15:22
 *
 * @author Alex Soroka
 */
@Controller
@RequestMapping ("/")
public class TestController {

    @RequestMapping(value = "/test")
    public String getHomePageUrl () {
        return "resources/SpecRunner.html";
    }

}
