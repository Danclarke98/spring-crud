package com.example.spring.controller;

import com.example.spring.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)

    public String index(Model model){

        User user = new User();
        user.setFname("Daniel");
        user.setLname("Clarke");
        user.setPassword("pass");


        model.addAttribute("user", user);
        return "index";
    }


}
