package com.endava.project.user.service;

import com.endava.project.administrator.entity.Role;
import com.endava.project.user.entity.User;
import com.endava.project.user.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    User saveUser(User user);

    List<Role> listRoles();

    User getUser(Integer id) throws UserNotFoundException;

    User updateUser(User user, Integer id);

    void deleteUser(Integer id) throws UserNotFoundException;

}
