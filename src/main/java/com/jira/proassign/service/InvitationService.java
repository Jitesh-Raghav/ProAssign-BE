package com.jira.proassign.service;

import com.jira.proassign.entity.Invitation;
import com.jira.proassign.exception.MailsException;
import jakarta.mail.MessagingException;

public interface InvitationService {
    public void sendInvitation(String email, Long projectId) throws MailsException, MessagingException;

    public Invitation acceptInvitation(String token, Long userId) throws Exception;
    public String getTokenByUserMail(String userEmail);
    public void deleteToken(String token);

}
