package com.endava.project.security;

import com.endava.project.user.service.impl.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // set authentication provider
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    // configuration for authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable();

        http.authorizeRequests()
                .mvcMatchers("/index, /users", "/login", "/doctors", "/categories", "/services", "/users/info/**").permitAll()
                .mvcMatchers("/users/**").hasAnyAuthority("Admin", "Moderator")
                .mvcMatchers("/categories/**").hasAnyAuthority("Admin", "Moderator")
                .mvcMatchers("/doctors/**").hasAnyAuthority("Admin", "Moderator")
                .mvcMatchers("/services/**").hasAnyAuthority("Admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("email")
                    .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
         web.ignoring().antMatchers("/images/**",
                 "/js/**",
                 "/webjars/**",
                 "/favicon.ico",
                 "/resources/**",
                 "/error",
                 "/static/fontawesome/all.css");
    }
}

