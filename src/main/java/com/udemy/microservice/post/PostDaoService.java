package com.udemy.microservice.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.udemy.microservice.user.User;

@Component
@Repository
public class PostDaoService {
	
	@Autowired
	PostRepository postRepository;

	private static List<Post> posts=new ArrayList<>();
	
	public Post createPost(Post post) {
		postRepository.save(post);
		return post;
	}
	
	public List<Post> getAllPost(){
		return postRepository.findAll();
	}
	
	public Post getPostById(int id){
		Post postObj=null;
		for(Post post:posts){
			if(post.getId()==id){
				postObj = post;
			}
		}
		return postObj;
	}
	
	public Post getPostByIdJPA(int id){
		Optional<Post> postObj=postRepository.findById(id);
		return postObj.get();
	}
	
	public List<Post> getAllPostByUser(User user){
		List<Post> posts = postRepository.findByUser_UserId(user.getUserId());
		return posts;
	}
	
	
}
