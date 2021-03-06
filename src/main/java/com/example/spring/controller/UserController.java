package com.example.spring.controller;

import com.example.spring.domain.User;
import com.example.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerView(Model model){

        User user = new User();
        model.addAttribute("user", user);

        return "user/register";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)

    public String register(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){


            model.addAttribute("user", user);
            model.addAttribute("message", "Please Enter information in each field");
            return "user/register";


        }
        userService.save(user);
        return "redirect:/";

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginView(Model model){

        User user = new User();
        model.addAttribute("user", user);

        return "user/login";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)

    public String login(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult, HttpSession session){

        if(bindingResult.hasErrors()){


            model.addAttribute("user", user);
            model.addAttribute("message", "Please Enter information in each field");
            return "user/login";


        }

        if(userService.validateLogin(user)==null || userService.validateLogin(user).size()==0){
            model.addAttribute("user", user);
            model.addAttribute("message", "Account does not exist or incorrect");
            return "user/login";

        }


        session.setAttribute("author", user.getUsername());
        session.setAttribute("login", true);
        return "redirect:/";

    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session){

        if(session.getAttribute("login")==null){

            return "redirect:/user/login";

        }


        session.removeAttribute("login");

        return "redirect:/user/login";

    }

    @RequestMapping(value = "/update/{user}", method = RequestMethod.GET)
    public String updateView(Model model, @PathVariable User user, HttpSession session){

        if(session.getAttribute("login")==null){

            return "redirect:/user/login";

        }

        model.addAttribute("user", user);

        return "user/update";

    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute User user){


        userService.save(user);


        return "redirect:/user/admin";

    }


    @RequestMapping(value = "/delete/{user}", method = RequestMethod.GET)
    public String delete(@PathVariable User user, HttpSession session){

        if(session.getAttribute("login")==null){

            return "redirect:/user/login";

        }

        String name = user.getUsername();
        userService.delete(user);

        return "redirect:/user/admin";



    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String index(Model model, HttpSession session){

        if(session.getAttribute("login")==null){

            return "redirect:/user/login";



        }

        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "user/admin";
    }


}
