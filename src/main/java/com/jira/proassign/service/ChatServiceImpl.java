package com.jira.proassign.service;

import com.jira.proassign.entity.Chat;
import com.jira.proassign.entity.User;
import com.jira.proassign.exception.ChatException;
import com.jira.proassign.exception.ProjectException;
import com.jira.proassign.repository.ChatRepository;
import com.jira.proassign.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public Chat createChat(Long projectId, List<Long> userIds) {
        return null;
    }
//
    @Override
    public List<Chat> getChatsByProjectId(Long projectId) throws ChatException, ProjectException {
        return chatRepository.findByProjectId(projectId);
    }


    @Override
    public Chat addUsersToChat(Long chatId, List<Long> userIds) throws ChatException {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new ChatException("Chat not found with id: " + chatId));

        List<User> usersToAdd = userRepository.findAllById(userIds);

        chat.getUsers().addAll(usersToAdd);

        return chatRepository.save(chat);
    }

        @Override
    public List<Chat> searchChatsByName(String name) throws ChatException {
        List<Chat> searchedChats = chatRepository.findByProjectNameContainingIgnoreCase(name);
        if(searchedChats!=null) return searchedChats;
        throw new ChatException("Chats not available");
    }

    // Other methods as needed
}
