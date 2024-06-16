package com.jira.proassign.service;

import com.jira.proassign.entity.Chat;
import com.jira.proassign.exception.ChatException;
import com.jira.proassign.exception.ProjectException;

import java.util.List;

public interface ChatService {

    Chat createChat(Chat chat) ;

    Chat createChat(Long projectId, List<Long> userIds);

    List<Chat> getChatsByProjectId(Long projectId) throws ChatException, ProjectException;

	Chat addUsersToChat(Long chatId, List<Long> userIds) throws ChatException, ChatException;


	 List<Chat> searchChatsByName(String name) throws ChatException;

    // Other methods as needed
}
