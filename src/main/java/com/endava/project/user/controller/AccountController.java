package com.endava.project.user.controller;

import com.endava.project.security.MyUserDetails;
import com.endava.project.user.entity.User;
import com.endava.project.user.service.impl.CustomUserDetailsService;
import com.endava.project.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String viewDetails(@AuthenticationPrincipal MyUserDetails loggedUser, Model model) {
        String email = loggedUser.getUsername();
        User user = userService.getByEmail(email);
        model.addAttribute("user", user);
        return "account_form";
    }

    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public String daveUserDetails(User user, RedirectAttributes redirectAttributes, @AuthenticationPrincipal MyUserDetails actualUser ) {
        System.out.println(user);
        userService.updateAccountDetails(user);
        redirectAttributes.addFlashAttribute("message", "Success");
        return "redirect:/account";
    }
}
