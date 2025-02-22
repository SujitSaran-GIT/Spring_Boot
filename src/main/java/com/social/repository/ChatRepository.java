package com.social.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.social.model.Chat;
import com.social.model.User;

public interface ChatRepository extends JpaRepository<Chat,Integer>{

	public List<Chat> findByUsersId(Integer userId);
	
//	public Chat findChatByUsersId(@Param("user") User user, @Param("reqUser") User reqUser);

	@Query("select c from Chat c Where :user Member of c.users And :reqUser Member of c.users")
	public Chat findChatByUsersId(@Param("user") User user2, @Param("reqUser") User reqUser);
	
}
