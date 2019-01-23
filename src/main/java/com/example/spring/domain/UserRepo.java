package com.example.spring.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long>{
    List<User> findByUsernameAndPassword(String username, String password);
}
