package com.example.springbootjersey.config;

import com.example.springbootjersey.controller.UserController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.jersey.ResourceConfigCustomizer;
import org.springframework.stereotype.Component;

@Component
public class MyResourceConfigCustomizer implements ResourceConfigCustomizer {
    @Override
    public void customize(ResourceConfig config) {
        config.register(UserController.class);
    }
}