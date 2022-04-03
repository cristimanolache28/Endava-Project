package com.endava.project.user.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



// This controller is for endpoint testing
@Controller
public class MainController {

    @GetMapping()
    public String viewHomePage() {
        return "index";
    }

    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLoginPage() {
        return "/login";
    }

}
