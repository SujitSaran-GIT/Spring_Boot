package com.social.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social.model.User;
import com.social.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
//	Send user data 
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(user.getPassword());
		newUser.setId(user.getId());
		
//		save the user
		User savedUser = userRepository.save(newUser);
		return savedUser;
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
//		Creating an empty array list of users
		List<User> users = new ArrayList<>();
		User user1 = new User(1,"Sujit","Saran","sujitsaran16@gmail.com","Saran@20002");
		users.add(user1);
		User user2 = new User(2,"Sumit","Saran","sumitsaran16@gmail.com","Saran@20006");
		users.add(user2);
		return users;
	}
//	Get specific user data by id
	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable("userId") Integer id) {
//		Creating an empty array list of users
		User user1 = new User(1,"Sujit","Saran","sujitsaran16@gmail.com","Saran@20002");
		user1.setId(id);
		
		return user1;
	}
	
	
//	Update anything in the user
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		User user1 = new User(1,"Sujit","Saran","sujitsaran16@gmail.com","Saran@20002");
		if(user.getFirstName()!=null) {
			user1.setFirstName(user.getFirstName());
		}
		
		if(user.getLastName()!=null) {
			user1.setLastName(user.getLastName());
		}
		
		if(user.getEmail()!=null) {
			user1.setEmail(user.getEmail());
		}
		
		if(user.getPassword()!=null) {
			user1.setPassword(user.getPassword());
		}
		return user1;
	}
	
//	Delete anything in the user
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable Integer userId) {
		return "User deleted successfully"+userId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
