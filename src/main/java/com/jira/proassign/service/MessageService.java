package com.jira.proassign.service;

import com.jira.proassign.entity.Message;
import com.jira.proassign.exception.ChatException;
import com.jira.proassign.exception.ProjectException;
import com.jira.proassign.exception.UserException;

import java.util.List;

public interface MessageService {

    Message sendMessage(Long senderId, Long chatId, String content) throws UserException, ChatException, ProjectException;

    List<Message> getMessagesByProjectId(Long projectId) throws ProjectException, ChatException;
}