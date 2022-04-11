package com.endava.project.user.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String viewHomePage() {
        return "index";
    }

    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLoginPage() {
        return "/login";
    }

}
