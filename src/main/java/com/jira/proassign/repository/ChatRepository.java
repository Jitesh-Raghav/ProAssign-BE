package com.jira.proassign.repository;

import com.jira.proassign.entity.Chat;
import com.jira.proassign.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    Chat findByProject(Project projectById);

//	List<Chat> findByProjectNameContainingIgnoreCase(String projectName);
}