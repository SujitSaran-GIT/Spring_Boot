package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.model.User;
import com.social.repository.UserRepository;
import com.social.services.UserService;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
//	Send user data 
	
	@Autowired
	UserService userService;
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
//		User newUser = new User();
//		newUser.setEmail(user.getEmail());
//		newUser.setFirstName(user.getFirstName());
//		newUser.setLastName(user.getLastName());
//		newUser.setPassword(user.getPassword());
//		newUser.setId(user.getId());
		
//		save the user
//		User savedUser = userRepository.save(newUser);
//		After importing UserService no need to write them
		User savedUser = userService.registerUser(user);
		return savedUser;
	}
	
	@GetMapping("/api/users")
	public List<User> getUsers() {
//		Creating an empty array list of users
//		List<User> users = new ArrayList<>();
//		User user1 = new User(1,"Sujit","Saran","sujitsaran16@gmail.com","Saran@20002");
//		users.add(user1);
//		User user2 = new User(2,"Sumit","Saran","sumitsaran16@gmail.com","Saran@20006");
//		users.add(user2);
		List<User> users = userRepository.findAll();
//		findAll() is used for retrieve the data from the database
		return users;
	}
//	Get specific user data by id
	@GetMapping("/api/users/{userId}")
	public User getUserById(@PathVariable("userId") Integer id) throws Exception {
//		Creating an empty array list of users
//		User user1 = new User(1,"Sujit","Saran","sujitsaran16@gmail.com","Saran@20002");
//		user1.setId(id);
//		Optional means whether if there is user exist or not
//		Optional<User> user = userRepository.findById(id);
//		
//		if(user.isPresent()) {
//			return user.get();
//		}
//		throw new Exception("User not exist with user id"+id);
		User user = userService.findUserById(id);
		return user;
	}
	
	
//	Update anything in the user
	@PutMapping("/api/users/{userId}")
//	@Requestbody is used for retrieve the data from the database
	public User updateUser(@RequestBody User user,@PathVariable Integer userId) throws Exception{
//		Optional<User> user1 = userRepository.findById(userId);
////		User user1 = new User(1,"Sujit","Saran","sujitsaran16@gmail.com","Saran@20002");
//		if(user1.isEmpty()) {
//			throw new Exception("User not exist with id"+userId);
//		}
//		User oldUser = user1.get();
//		
//		if(user.getFirstName()!=null) {
//			oldUser.setFirstName(user.getFirstName());
//		}
////		
//		if(user.getLastName()!=null) {
//			oldUser.setLastName(user.getLastName());
//		}
////		
//		if(user.getEmail()!=null) {
//			oldUser.setEmail(user.getEmail());
//		}
////		
//		if(user.getPassword()!=null) {
//			oldUser.setPassword(user.getPassword());
//		}
//		
		User updatedUser = userService.updateUser(user, userId);
		return updatedUser;
	}
	
	//	Delete anything in the user
//	@DeleteMapping("/users/{userId}")
//	public String deleteUser(@PathVariable("userId") Integer userId) throws Exception{
//		Optional<User> user = userRepository.findById(userId);
//		
//		if(user.isEmpty()) {
//			throw new Exception("User not exist with id"+userId);
//		}
//		
//		userRepository.delete(user.get());
//		return "User deleted successfully"+userId;
//	}
//	
	@PutMapping("/api/users/follow/{userId1}/{userId2}")
	public User followUserHandler(@PathVariable Integer userId1,@PathVariable Integer userId2) throws Exception {
		User user = userService.followUser(userId1, userId2);
		return user;
	}
	
	
	@GetMapping("/api/users/search")
	public List<User> searchUser(@RequestParam("query") String query){
		List<User> users = userService.searchUser(query);
		return users;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}