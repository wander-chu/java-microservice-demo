package com.example.springbootjersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJerseyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJerseyApplication.class, args);
    }

    @Bean
    public ResourceConfig resourceConfig() {
        return new ResourceConfig();
    }
}