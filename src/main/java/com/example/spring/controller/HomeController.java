package com.example.spring.controller;

import com.example.spring.domain.Post;
import com.example.spring.domain.User;
import com.example.spring.service.PostService;
import com.example.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpSession session){

        if(session.getAttribute("login")==null){

            return "redirect:/user/login";



        }

        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewPost(Model model){

        List<Post> posts = postService.findAll();

        model.addAttribute("posts",posts);



        return "post/viewPost";
    }





}
