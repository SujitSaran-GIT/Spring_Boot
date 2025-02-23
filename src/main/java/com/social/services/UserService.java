package com.social.services;

import java.util.List;

import com.social.exception.UserException;
import com.social.model.User;

public interface UserService {
	public User registerUser(User user);
	public User findUserById(Integer userId) throws UserException;
	public User finduserByEmail(String email);
	public User followUser(Integer userId1,Integer userId2) throws UserException;
	public User updateUser(User user,Integer userId) throws UserException;
	public List<User> searchUser(String query);
	public User findUserByJwt(String jwt);
}