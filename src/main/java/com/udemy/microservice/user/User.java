package com.udemy.microservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.microservice.post.Post;

@Entity(name="USER")
//@JsonFilter("DOBFilter")
public class User {

	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
	@Size(min=2, message="Name should have at least 2 characters")
	private String userName;
	
	@Column(name="USER_DOB")
	@Past(message="Date cannot be the future date")
	private Date dateOfBirth;
	
	/*@OneToMany
	@JoinColumn(name = "POST_ID")
	@JsonIgnore
	private List<Post> posts = new ArrayList<>();*/
	
	public User() {

	}
	
	public User(int userId, String userName, Date dateOfBirth) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/*public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	*/
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
}
