package com.social.repository;

import java.util.List;

import com.social.model.Story;
import com.social.model.User;


public interface StoryService {

	public Story createStory(Story story,User user);
	
	public List<Story> findStoryByUserId(Integer userId) throws Exception;
}
