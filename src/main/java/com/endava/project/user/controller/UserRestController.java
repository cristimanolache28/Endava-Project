package com.endava.project.user.controller;

import com.endava.project.user.entity.User;
import com.endava.project.user.exception.UserNotFoundException;
import com.endava.project.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserRestController {

    // Tells the app context to inject an instance of UserServiceImpl here
    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public List<User> getAllUsers() {
        // The UserServiceImpl is already injected and I can use it
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveNewUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") Integer id,@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Integer id) throws UserNotFoundException {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
    }


    // Stream Api
    @GetMapping("/secret")
    public List<String> getUserWithRoles() {
        return userService.getNameUserWithHisRoles();
    }

    @GetMapping("number-of-users")
    public int getTotalNumberOfUsers() {
        return userService.getTotalNumberOfUser();
    }



}
