package com.endava.project.user.service.impl;

import com.endava.project.user.entity.Role;
import com.endava.project.user.repository.RoleRepository;
import com.endava.project.user.exception.UserNotFoundException;
import com.endava.project.user.entity.User;
import com.endava.project.user.repository.UserRepository;
import com.endava.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

//    @Override
//    public void saveUser(User user) {
//        boolean isUpdatingUser = (user.getId() != null);
//        if (isUpdatingUser) {
//            User userExisting = userRepository.findById(user.getId()).get();
//            if (user.getPassword().isEmpty()) {
//                user.setPassword(userExisting.getPassword());
//            } else {
//                encodePassword(user);
//            }
//        } else {
//            encodePassword(user);
//        }
//        userRepository.save(user);
//    }


    @Override
    public User saveUser(User user) {
        encodePassword(user);
        return userRepository.save(user);
    }

    @Override
    public User updateAccountDetails(User updateUser) {
        User user = userRepository.findById(updateUser.getId()).get();

        if (!updateUser.getPassword().isEmpty()) {
            user.setPassword(updateUser.getPassword());
            encodePassword(user);
        }

        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setPhoneNumber(updateUser.getPhoneNumber());
        user.setAge(updateUser.getAge());
        return userRepository.save(user);
    }

    @Override
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    @Override
    public User getUser(Integer id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public void deleteUser(Integer id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id " + id + " not found"));
        userRepository.delete(user);
    }

    @Override
    public User updateUser(User user, Integer id) {
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id " + id + " not found" ));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPassword(user.getPassword());
        encodePassword(existingUser);
        existingUser.setEmail(user.getEmail());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setAge(user.getAge());

        userRepository.save(existingUser);
        return existingUser;
    }


    private void encodePassword(User user) {
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
    }


    //=================Stream API - Service Layer ==========================
    public List<String> getNameUserWithHisRoles() {
        List<User> usersList = userRepository.findAll();
        return usersList.stream()
                .map(u -> "Id: " + u.getId() + " " +
                        u.getFirstName() + " " +
                        u.getLastName() + " "
                        + u.getRoles())
                .collect(Collectors.toList());
    }

    public int getTotalNumberOfUser() {
        List<User> usersList = userRepository.findAll();
        return (int) usersList.stream()
                .filter(user -> user.getId() != 0)
                .count();
    }

    public int getMajorUsersNumber() {
        List<User> usersList = userRepository.findAll();
        return (int) usersList.stream()
                .filter(user -> user.getAge() >= 18)
                .count();
    }

    public User getUserByFirstname(String firstName) {
        List<User> usersList = userRepository.findAll();
        return usersList.stream()
                .filter(user -> user.getFirstName().equals(firstName))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public List<String> displayAllMajorUsers() {
        List<User> usersList = userRepository.findAll();
        return usersList.stream()
                .filter(user -> user.getAge() >= 18)
                .map(user -> user.getFirstName() + " "
                        + user.getLastName() + " "
                        + user.getFirstName() + " "
                        + user.getEmail() + " "
                        + user.getPhoneNumber() + " "
                        + user.getRoles() + " "
                        + user.getAge() + "\n")
//                .collect(Collectors.joining());
                .collect(Collectors.toList());
    }

}
