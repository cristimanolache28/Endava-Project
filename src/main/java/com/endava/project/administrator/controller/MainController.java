package com.endava.project.administrator.controller;

import com.endava.project.user.entity.User;
import com.endava.project.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
