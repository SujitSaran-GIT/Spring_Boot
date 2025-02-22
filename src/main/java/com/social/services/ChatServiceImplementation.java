package com.social.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.model.Chat;
import com.social.model.User;
import com.social.repository.ChatRepository;

@Service
public class ChatServiceImplementation implements ChatService{
	
	@Autowired
	private ChatRepository chatRepository;

	@Override
	public Chat createChat(User reqUser, User user) {
		// TODO Auto-generated method stub
		Chat isExist = chatRepository.findChatByUsersId(user,reqUser);
		
		if(isExist!=null) {
			return isExist;
		}
		Chat chat = new Chat();
		
		chat.getUsers().add(user);
		chat.getUsers().add(reqUser);
		chat.setTimestamp(LocalDateTime.now());
		
		return chatRepository.save(chat);
	}

	@Override
	public Chat findChatById(Integer chatId) throws Exception {
		// TODO Auto-generated method stub
		Optional<Chat> opt = chatRepository.findById(chatId);
		
		if(opt.isEmpty()) {
			throw new Exception("Chat not found with Id"+chatId);
		}
		return opt.get();
	}

	@Override
	public List<Chat> findUsersChat(Integer userId) {
		// TODO Auto-generated method stub
		
		return chatRepository.findByUsersId(userId);
	}

}
