package com.example.spring.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo  extends JpaRepository<Post, Long> {
}
