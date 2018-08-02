package com.udemy.microservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.udemy.microservice.exceptions.UserNotFoundException;

@Repository
public class UserDaoService {

	@Autowired
	UserRepository userRepository;
	
	private static List<User> users=new ArrayList<>();
	static{
		users.add(new User(1,"Adarsh",new Date(26-6-1990)));
		users.add(new User(2,"Yashu",new Date(9-7-1992)));
		users.add(new User(3,"Ria",new Date(11-8-1989)));
	}
	
	public User createUser(User user){
		userRepository.save(user);
		return user;
	}
	
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	public User getUserById(int id){
		User userObj=null;
		for(User user:users){
			if(user.getUserId()==id){
				userObj = user;
			}
		}
		return userObj;
	}
	
	public User getUserByIdJPA(int id) throws UserNotFoundException {
		Optional<User> userObj=userRepository.findById(id);
		if(!userObj.isPresent()){
			throw new UserNotFoundException("User was not found for Id "+id);
		}
		return userObj.get();
	}
}
