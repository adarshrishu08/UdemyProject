package com.udemy.microservice.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udemy.microservice.post.Post;
import com.udemy.microservice.post.PostDaoService;
import com.udemy.microservice.user.User;
import com.udemy.microservice.user.UserDaoService;

@RestController
@RequestMapping("/service")
public class ServiceController {

	@Autowired
	UserDaoService userService;
	@Autowired
	PostDaoService postService;

	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User createdUser = userService.createUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUser.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "/users/{id}")
	public User getUser(@Valid @PathVariable int id) {
		User userResult = userService.getUserByIdJPA(id);
		/*
		  SimpleBeanPropertyFilter simpleBeanPropertyFilter =
		  SimpleBeanPropertyFilter.filterOutAllExcept("userId","userName");
		  FilterProvider filterProvider = new
		  SimpleFilterProvider().addFilter("DOBFilter",
		  simpleBeanPropertyFilter); MappingJacksonValue mapping = new
		  MappingJacksonValue(userResult); mapping.setFilters(filterProvider);
		*/
		return userResult;
	}

	@GetMapping(path = "/users")
	public List<User> getAllUser() {
		List<User> createdUser = userService.getAllUser();
		return createdUser;
	}
	
	
	@PostMapping(path = "/posts")
	public ResponseEntity<Object> createPost(@Valid @RequestBody Post post) {
		Post createdPost = postService.createPost(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdPost.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = "/posts/{id}")
	public Post getPost(@Valid @PathVariable int id) {
		Post postResult = postService.getPostByIdJPA(id);
		return postResult;
	}
	
	@GetMapping(path = "/posts")
	public List<Post> getAllPost() {
		List<Post> createdPost = postService.getAllPost();
		return createdPost;
	}
	
	@GetMapping(path="/users/{id}/posts")
	public List<Post> getPostsForUser(@PathVariable int id){
		User user = userService.getUserById(id);
		List<Post> postsForUser = postService.getAllPostByUser(user);
		return postsForUser;
	}
	
	@GetMapping(path="/users/{userid}/posts/{postid}")
	public Post getPostsForUser(@PathVariable int userid, @PathVariable int postid){
		User user = userService.getUserById(userid);
		List<Post> postsForUser = postService.getAllPostByUser(user);
		Post post = postsForUser.stream().filter(i->i.getId()==postid).findAny().orElse(null);
		return post;
	}
}
