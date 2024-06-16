package com.jira.proassign.service;


import com.jira.proassign.entity.Chat;
import com.jira.proassign.entity.Project;
import com.jira.proassign.entity.User;
import com.jira.proassign.exception.ChatException;
import com.jira.proassign.exception.ProjectException;
import com.jira.proassign.exception.UserException;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project, Long userId) throws UserException;

//	List<Project> getProjectsByOwner(User owner) throws ProjectException;

    List<Project> getProjectsByTeam(User user, String category, String tag) throws ProjectException;


    Project getProjectById(Long projectId) throws ProjectException;

    String deleteProject(Long projectId,Long userId) throws UserException;

    Project updateProject(Project updatedProject, Long id) throws ProjectException;

    List<Project> searchProjects(String keyword, User user) throws ProjectException;

    void addUserToProject(Long projectId, Long userId) throws UserException, ProjectException;

    void removeUserFromProject(Long projectId, Long userId) throws UserException, ProjectException;

    Chat getChatByProjectId(Long projectId) throws ProjectException, ChatException;



}

