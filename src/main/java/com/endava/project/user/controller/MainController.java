package com.endava.project.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



// This controller is for endpoint testing
@Controller
public class MainController {

    @GetMapping()
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "/login";
    }

}
