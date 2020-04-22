package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.command.LoginCommand;
import com.app.command.UserCommand;
import com.app.domain.User;
import com.app.exception.UserBlockException;
import com.app.service.UserService;

@Controller
public class UserController {
    
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value= {"/","/index"})
	public String index(Model m) {
		m.addAttribute("command",new LoginCommand());
		return "index"; //jsp -/ WEB-INF/view/index.jsp
		
	}
	
	
	@RequestMapping(value="/login",method= RequestMethod.POST)
	public String handlelogin(@ModelAttribute("command")LoginCommand cmd ,Model m,HttpSession session) {
		
	try {
		User logedInUser=userservice.login(cmd.getLoginName(),cmd.getPassword());
		 if(logedInUser==null) {
		 //add error msg go back to login form
	      m.addAttribute("err", "Login failed Enter valid cridential"); 
		 }
		 else {
			 //success
			 //check the role redirect to apropriate dashboard
			 if(logedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
				 addUserInSession(logedInUser,session);
				return "redirect:admin/dashboard"; 
			 }else if(logedInUser.getRole().equals(UserService.ROLE_USER)) {
				 addUserInSession(logedInUser,session);
				 return "redirect:user/dashboard";
			 }else {
			   //add error msg go back to login form
				m.addAttribute("err","Invalid User role");
			 }
		}
	     } catch (UserBlockException ex) {
		//add error msg go back to login form
	    m.addAttribute("err",ex.getMessage());
		
	}
	return "index";//jsp login Form
		
				
	}
	
	  @RequestMapping(value="/logout")
	  public String logout(HttpSession session) {
	  session.invalidate();
	  return "redirect:index?act=lo"; //jsp -/ WEB-INF/view/index.jsp
		
	}
		
	@RequestMapping(value="/user/dashboard")
	public String userDashboard() {
		return "dashboard_user"; //jsp -/ WEB-INF/view/index.jsp
		
	}
	
	@RequestMapping(value="/admin/dashboard")
	public String adminDashboard() {
		return "dashboard_admin"; //jsp -/ WEB-INF/view/index.jsp
		
	}
	
	@RequestMapping(value="/reg_from")
	public String registrationForm(Model m) {
		UserCommand cmd=new UserCommand();
		m.addAttribute("command",cmd);
		return "reg_from";
		
	}
	
	@RequestMapping(value="/register")
	public String registerUser(@ModelAttribute("command") UserCommand cmd,Model m) {
		
		try {
		User user=cmd.getUser();
		user.setRole(userservice.ROLE_ADMIN);
		user.setLoginStatus(userservice.LOGIN_STATUS_ACTIVE);
		userservice.register(user);
		return "redirect:index?act=reg";
		}catch(DuplicateKeyException e) {
		 e.printStackTrace();
		 m.addAttribute("err","This user Name already register please select other name");
		 return "reg_from"; //jsp
		}	
		
	}
	
	
	private void addUserInSession(User u, HttpSession session) {
	 session.setAttribute("user", u);
	 session.setAttribute("userId", u.getUserId());
	 session.setAttribute("role", u.getRole());
		
	}
	
}
