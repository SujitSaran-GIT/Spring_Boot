package com.social.services;

import java.util.List;

import com.social.model.Chat;
import com.social.model.User;

public interface ChatService {

	public Chat createChat(User reqUser,User user);
	
	public Chat findChatById(Integer chatId) throws Exception;
	
	public List<Chat> findUsersChat(Integer userId);
}
