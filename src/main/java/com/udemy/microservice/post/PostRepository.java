package com.udemy.microservice.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Integer>{

	public List<Post> findByUser_UserId(int userId);
}
