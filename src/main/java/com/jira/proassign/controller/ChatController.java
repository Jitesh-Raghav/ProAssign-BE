package com.jira.proassign.controller;

import com.jira.proassign.entity.Chat;
import com.jira.proassign.exception.ChatException;
import com.jira.proassign.exception.ProjectException;
import com.jira.proassign.request.CreateChat;
import com.jira.proassign.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/create")
    public ResponseEntity<Chat> createChat(@RequestBody CreateChat chat) throws ProjectException {
        Chat createChat = chatService.createChat(chat.getProjectId(), chat.getUserIds());
        return ResponseEntity.ok(createChat);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Chat>> getChatsByProjectId(@PathVariable Long projectId) throws ChatException, ProjectException, ChatException {
        List<Chat> chat =  chatService.getChatsByProjectId(projectId);
        return ResponseEntity.ok(chat);
    }

    @PostMapping("/{chatId}/addUsers")
    public ResponseEntity<Chat> addUsersToChat(@PathVariable Long chatId,
                               @RequestParam List<Long> userIds) throws ChatException {
           Chat addedUsersToChat = chatService.addUsersToChat(chatId, userIds);
           return ResponseEntity.ok(addedUsersToChat);
    }

//    @GetMapping("/search")
//    public ResponseEntity<List<Chat>> searchChatsByName(@RequestParam String name) throws ChatException {
//        List<Chat> chats = chatService.searchChatsByName(name);
//        return ResponseEntity.ok(chats);
//    }

    // Other endpoints as needed
}


