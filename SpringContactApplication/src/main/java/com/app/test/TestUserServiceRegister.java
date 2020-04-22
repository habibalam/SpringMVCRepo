package com.app.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.SpringRootConfig;
import com.app.dao.UserDAO;
import com.app.domain.User;
import com.app.service.UserService;

public class TestUserServiceRegister {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);	
     
	UserService userService=ctx.getBean(UserService.class);
	// user details taking from registration form
	User u=new User();
	u.setName("Moazzam");
	u.setPhone("9800877808");
	u.setEmail("mo@gmail.com");
	u.setAddress("patna");
	u.setLoginName("moazzam12");
	u.setPassword("mozo123");
	u.setRole(userService.ROLE_ADMIN);//admin role
	u.setLoginStatus(userService.LOGIN_STATUS_ACTIVE);//active
	userService.register(u);
	System.out.println("User Register successfully");
	
	}

}
