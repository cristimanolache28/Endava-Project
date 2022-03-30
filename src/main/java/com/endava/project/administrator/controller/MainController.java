package com.endava.project.administrator.controller;

import com.endava.project.user.entity.User;
import com.endava.project.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class MainController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping()
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> users = userService.listUsers();
        return users;
    }

}
