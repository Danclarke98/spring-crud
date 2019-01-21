package com.example.spring.service;

import com.example.spring.domain.User;
import com.example.spring.domain.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User save(User u){
        return  userRepo.save(u);
    }
}
