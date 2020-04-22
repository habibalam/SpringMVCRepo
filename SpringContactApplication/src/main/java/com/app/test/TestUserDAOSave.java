package com.app.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.SpringRootConfig;
import com.app.dao.UserDAO;
import com.app.domain.User;

public class TestUserDAOSave {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);	
     
	UserDAO userdao=ctx.getBean(UserDAO.class);
	// user details taking from registration form
	User u=new User();
	u.setName("Atab Alam");
	u.setPhone("98787788");
	u.setEmail("aftabalam@gmail.com");
	u.setAddress("patna");
	u.setLoginName("aftab2");
	u.setPassword("3434");
	u.setRole(1);//admin role
	u.setLoginStatus(1);//active
	userdao.save(u);
	System.out.println("Data successfully save in your database");
	
	}

}
