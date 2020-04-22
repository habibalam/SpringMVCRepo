package com.app.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.SpringRootConfig;
import com.app.dao.UserDAO;
import com.app.domain.User;

public class TestUserDAOFindAll {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);	
     
	UserDAO userdao=ctx.getBean(UserDAO.class);
	// user details taking from registration form
    List<User> users =userdao.findAll();
    for(User u:users)
    {
    	System.out.println(u.getUserId()+""+u.getName()+""+u.getPhone()+""+u.getEmail()+""+u.getPassword()+""+u.getLoginName()+""+u.getLoginStatus()+""+u.getRole());
    }
    
	System.out.println("-----------User Details----------");
	
	
	}

}
