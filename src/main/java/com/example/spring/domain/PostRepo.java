package com.example.spring.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo  extends JpaRepository<Post, Long> {


    @Query ("SELECT p FROM Post p WHERE p.title LIKE %?1%")
    List<Post> searchPost(String title);
}
