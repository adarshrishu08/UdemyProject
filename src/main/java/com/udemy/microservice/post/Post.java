package com.udemy.microservice.post;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.udemy.microservice.user.User;

@Entity(name="POST")
public class Post {

	@Id
	@Column(name="POST_ID")
	@GeneratedValue
	private int id;
	
	@Size(max=500)
	@Column(name="POST_DESC", length=500)
	private String description;
	
	@PastOrPresent
	@Column(name="POST_DATE")
	private Date dateOfPost;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOfPost() {
		return dateOfPost;
	}

	public void setDateOfPost(Date dateOfPost) {
		this.dateOfPost = dateOfPost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
