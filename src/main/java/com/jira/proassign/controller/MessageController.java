package com.jira.proassign.controller;


import com.jira.proassign.entity.Chat;
import com.jira.proassign.entity.Message;
import com.jira.proassign.entity.User;
import com.jira.proassign.exception.ChatException;
import com.jira.proassign.exception.ProjectException;
import com.jira.proassign.exception.UserException;
import com.jira.proassign.request.CreateMessageRequest;
import com.jira.proassign.service.MessageService;
import com.jira.proassign.service.ProjectService;
import com.jira.proassign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://proassign.vercel.app/")
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;




    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody CreateMessageRequest request)
            throws UserException, ChatException, ProjectException {

        User user = userService.findUserById(request.getSenderId());
        if(user==null) throw new UserException("user Not found with id "+request.getSenderId());
        Chat chats = projectService.getProjectById(request.getProjectId()).getChat();  // This method should throw ChatException if the chat is not found
        if(chats==null) throw new ChatException("Chats not found");
        Message sentMessage = messageService.sendMessage(request.getSenderId(), request.getProjectId(), request.getContent());
        return ResponseEntity.ok(sentMessage);
    }

    @GetMapping("/chat/{projectId}")
    public ResponseEntity<List<Message>> getMessagesByChatId(@PathVariable Long projectId)
            throws ProjectException, ChatException {
        List<Message> messages = messageService.getMessagesByProjectId(projectId);
        return ResponseEntity.ok(messages);
    }
}


