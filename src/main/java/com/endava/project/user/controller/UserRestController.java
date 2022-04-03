package com.endava.project.user.controller;

import com.endava.project.user.entity.User;
import com.endava.project.user.exception.UserNotFoundException;
import com.endava.project.user.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/users")
// generate constructor for all final class's fields
//@RequiredArgsConstructor
public class UserRestController {

//     Tells the app context to inject an instance of UserServiceImpl here
    @Autowired
    private UserServiceImpl userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        // The UserServiceImpl is already injected and I can use it
        return userService.listUsers();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @PostMapping(value = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveNewUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }


    @PutMapping(value = "/edit/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUserById(@PathVariable("id") Integer id, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Integer id) throws UserNotFoundException {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
    }


    // Stream Api
    @GetMapping(value = "/secret", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getUserWithRoles() {
        return userService.getNameUserWithHisRoles();
    }

    @GetMapping("number-of-users")
    public int getTotalNumberOfUsers() {
        return userService.getTotalNumberOfUser();
    }



}
