package com.app.service;

import java.util.List;

import com.app.domain.User;
import com.app.exception.UserBlockException;

public interface UserService {
	
	public static final Integer LOGIN_STATUS_ACTIVE=1;
	public static final Integer LOGIN_STATUS_BLOCKED=2;
	public static final Integer ROLE_ADMIN=1;
	public static final Integer ROLE_USER=2;

	// the method handle the reigstration task 
	public void register(User u);
	
	// this method handle login operation authentication given cridential
	// throws Exception when UserBlockException when user is blocked 
	public User login(String loginName,String password) throws UserBlockException;
   
	// this method get user of register
	public List<User> getUserList();
    
	// this method change the user login status based for details passed as argument
	public void changeLoginStatus(Integer userId, Integer loginStatus);


}
