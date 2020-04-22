package com.app.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.SpringRootConfig;
import com.app.dao.UserDAO;
import com.app.domain.User;

public class TestUserDAOFindBy {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);	
     
	UserDAO userdao=ctx.getBean(UserDAO.class);
	// user details taking from registration form
    List<User> users =userdao.findByProperty("userId",1);
    for(User u:users)
    {
    	System.out.println(u.getUserId()+""+u.getName()+""+u.getRole());
    }
    
	System.out.println("-----------User Details Find By peroperty----------");
	
	
	}

}
