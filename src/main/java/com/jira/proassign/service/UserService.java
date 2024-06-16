package com.jira.proassign.service;


import com.jira.proassign.entity.User;
import com.jira.proassign.exception.ProjectException;
import com.jira.proassign.exception.UserException;

public interface UserService {

    public User findUserProfileByJwt(String jwt) throws UserException, ProjectException;

    public User findUserByEmail(String email) throws UserException;

    public User findUserById(Long userId) throws UserException, UserException;

    public User updateUsersProjectSize(User user,int number);

//	public List<User> findAllUsers();

//	public List<User> getPenddingRestaurantOwner();

    void updatePassword(User user, String newPassword);

    void sendPasswordResetEmail(User user);

//	void sendPasswordResetEmail(User user);
}
