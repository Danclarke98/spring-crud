package com.example.spring.service;

import com.example.spring.domain.Post;
import com.example.spring.domain.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepo postRepo;

    public Post save(Post p){
        return  postRepo.save(p);
    }

    public List<Post> findAll(){
        return postRepo.findAll();
    }

    public void delete(Post post){

        postRepo.delete(post);

    }






}
