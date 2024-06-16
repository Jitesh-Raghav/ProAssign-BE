package com.jira.proassign.repository;

import com.jira.proassign.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findByProjectId(Long projectById);

	List<Chat> findByProjectNameContainingIgnoreCase(String projectName);
}