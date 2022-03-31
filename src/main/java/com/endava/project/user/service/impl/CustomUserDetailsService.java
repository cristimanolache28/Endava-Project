package com.endava.project.user.service.impl;

import com.endava.project.security.MyUserDetails;
import com.endava.project.user.entity.User;
import com.endava.project.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
// spring security needs a way to retrieving user information. ( custom authentication)
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            return new MyUserDetails(user);
        }
        throw new UsernameNotFoundException("User with email " + email + " not found.");
    }
}
