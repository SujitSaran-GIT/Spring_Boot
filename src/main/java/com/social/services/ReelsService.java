package com.social.services;

import java.util.List;

import com.social.model.Reels;
import com.social.model.User;

public interface ReelsService {

	public Reels createReel(Reels reel,User user);
	public List<Reels> findAllReels();
	public List<Reels> findUSerReel(Integer userId) throws Exception;
	List<Reels> findUserReel(Integer userId) throws Exception;
}
