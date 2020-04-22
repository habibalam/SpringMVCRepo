package com.app.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.SpringRootConfig;
import com.app.dao.UserDAO;
import com.app.domain.User;

public class TestUserDAODelete {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);	
     
	UserDAO userdao=ctx.getBean(UserDAO.class);
	// user details taking from registration form

	userdao.delete(7);
	System.out.println("Data successfully Deleted");
	
	}

}
