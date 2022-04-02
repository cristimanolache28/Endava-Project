package com.endava.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EndavaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EndavaProjectApplication.class, args);
    }
}

// application class needs to be top of your package hierarchy, so that Spring can scan sub-packages and find out the other required components (beans).
