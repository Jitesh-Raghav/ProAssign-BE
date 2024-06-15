package com.jira.proassign.service;

import com.jira.proassign.entity.Comment;
import com.jira.proassign.exception.IssueException;
import com.jira.proassign.exception.UserException;

import java.util.List;

public interface CommentService {
    Comment createComment(Long issueId, Long userId, String comment) throws UserException, IssueException;

    void  deleteComment(Long commentId, Long userId) throws UserException, IssueException;

    List<Comment> findCommentByIssueId(Long issueId);

}
