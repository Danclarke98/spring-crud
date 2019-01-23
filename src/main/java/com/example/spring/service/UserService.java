package com.example.spring.service;

import com.example.spring.domain.User;
import com.example.spring.domain.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User save(User u){
        return  userRepo.save(u);
    }

    public List<User> findAll(){
        return userRepo.findAll();
    }

    public void delete(User user){

        userRepo.delete(user);

    }

    public List<User> validateLogin(User user){


       return userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());

    }

}
