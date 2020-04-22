package com.app.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.SpringRootConfig;
import com.app.dao.UserDAO;
import com.app.domain.User;

public class TestUserDAOUpdate {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);	
     
	UserDAO userdao=ctx.getBean(UserDAO.class);
	// user details taking from registration form
	User u=new User();
	u.setUserId(2);
	u.setName("Ravi kumar");
	u.setPhone("955656889");
	u.setEmail("ravi@gmail.net");
	u.setAddress("islampur");	
	u.setRole(1);//admin role
	u.setLoginStatus(1);//active
	userdao.update(u);
	System.out.println("Data successfully save in your database");
	
	}

}
