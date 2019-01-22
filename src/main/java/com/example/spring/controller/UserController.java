package com.example.spring.controller;

import com.example.spring.domain.User;
import com.example.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerView(Model model){

        User user = new User();
        model.addAttribute("user", user);

        return "register";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(Model model, @ModelAttribute("user") User user){

        userService.save(user);
        return "Registration Complete \n" + "Created: " + user.getFname() + " "+ user.getLname();

    }

    @RequestMapping(value = "/update/{user}", method = RequestMethod.GET)
    public String updateView(Model model, @PathVariable User user){

        model.addAttribute("user", user);

        return "update";

    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute User user){

        userService.save(user);


        return "redirect:/";

    }


    @RequestMapping(value = "/delete/{user}", method = RequestMethod.GET)

    public String delete(@PathVariable User user){

        String name = user.getFname()+ ' ' + user.getLname();
        userService.delete(user);

        return "redirect:/";



    }


}
