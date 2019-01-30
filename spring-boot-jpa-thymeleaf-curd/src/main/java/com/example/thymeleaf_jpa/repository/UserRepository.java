package com.example.thymeleaf_jpa.repository;

import com.example.thymeleaf_jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}