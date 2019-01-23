package com.example.spring.controller;
import com.example.spring.domain.User;
import com.example.spring.domain.UserRepo;
import com.example.spring.domain.Post;
import com.example.spring.domain.User;
import com.example.spring.service.PostService;
import com.example.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    PostService postService;
    @Autowired
    UserService userService;




    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createView(Model model){

        Post post = new Post();
        model.addAttribute("post",post);

        return "post/create";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @Valid @ModelAttribute("post") Post post, BindingResult bindingResult, HttpSession session){



        model.addAttribute("post", post);

        post.setAuthor(session.getAttribute("author").toString());

        postService.save(post);
        return "redirect:/view";

    }

}
