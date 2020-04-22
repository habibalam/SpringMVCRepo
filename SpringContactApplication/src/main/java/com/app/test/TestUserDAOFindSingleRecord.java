package com.app.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.SpringRootConfig;
import com.app.dao.UserDAO;
import com.app.domain.User;

public class TestUserDAOFindSingleRecord {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);	
     
	UserDAO userdao=ctx.getBean(UserDAO.class);
	// user details taking from registration form
   User u=userdao.findById(3);
	
	System.out.println("-----------User Details----------");
	System.out.println(u.getUserId());
	System.out.println(u.getName());
	System.out.println(u.getPhone());
	System.out.println(u.getEmail());
	System.out.println(u.getPassword());
	System.out.println(u.getLoginName());
	System.out.println(u.getLoginStatus());
	System.out.println(u.getRole());
	
	}

}
