package com.endava.project.user.controller;

import com.endava.project.user.entity.User;
import com.endava.project.administrator.entity.Role;
import com.endava.project.user.exception.UserNotFoundException;
import com.endava.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

// It includes the @Controller and @ResponseBode annotations.
// @ResponseBody annotation tells a controller that the object returned is
// automatically serialized into JSON and passed back into the HttpResponse object.
//@RestController
@Controller
@RequestMapping(value = "/api/users")
//@RequiredArgsConstructor TODO
public class UserController {

    @Autowired
    // inject dependency
    private UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    // handler method to handle list users and return mode and view
    @GetMapping
    public String getUsers(Model model) {
        List<User> listUsers = userService.listUsers();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        List<Role> listRoles = userService.listRoles();
        // create student object to hole student form data
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "create_user";
    }

    @PostMapping("/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes) {
        System.out.println(user);
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "Success");
        return "redirect:/api/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            List<Role> listRoles = userService.listRoles();
            model.addAttribute("listRoles", listRoles);
            User user = userService.getUser(id);
            model.addAttribute("user", user);
            return "update_user";
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/users";
        }


    }


}
