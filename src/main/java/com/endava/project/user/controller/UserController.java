package com.endava.project.user.controller;

import com.endava.project.user.entity.User;
import com.endava.project.user.entity.Role;
import com.endava.project.user.exception.UserNotFoundException;
import com.endava.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

// It includes the @Controller and @ResponseBody annotations.
// @ResponseBody annotation tells a controller that the object returned is
// automatically serialized into JSON and passed back into the HttpResponse object.
//@RestController
@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    // handler method to handle list users and return mode and view
    @GetMapping(value = "/management", produces = MediaType.APPLICATION_JSON_VALUE)
    public String managementAllUsers(Model model) {
        List<User> listUsers = userService.listUsers();
        model.addAttribute("listUsers", listUsers);
        return "users_management";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllUsers(Model model) {
        List<User> listUsers = userService.listUsers();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping(value = "/info/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getInfoAboutUsersById(@PathVariable("id") Integer id, Model model) {
        if (id < 0) {
            throw new UserNotFoundException("User with id " + id + " doesn't exist.");
        }
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "info_user";
    }

    @GetMapping(value = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public String addNewUser(Model model) {
        List<Role> listRoles = userService.listRoles();
        // create student object to hole student form data
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "create_user";
    }

    @PostMapping(value = "/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes) {
        System.out.println(user);
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "Success");
        return "redirect:/users";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUser(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            User user = userService.getUser(id);
            List<Role> listRoles = userService.listRoles();
            model.addAttribute("user", user);
            model.addAttribute("listRoles", listRoles);
            return "update_user";
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "User with id " + id + " doesn't exist");
            return "redirect:/users";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
