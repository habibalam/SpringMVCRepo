package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.domain.Contact;
import com.app.service.ContactService;

@Controller
public class ContactController {
    
	@Autowired
	private ContactService contactservice;
	
	@RequestMapping(value="/user/contact_form")
	public String contactForm(Model m)
	{   
		Contact contact=new Contact();
		m.addAttribute("command",contact);
		return "contact_form";//jsp		
	}
	
	@RequestMapping(value="/user/save_contact")
	public String savecontact(@ModelAttribute("command")Contact c,Model m ,HttpSession session)
	{  
		try {
		Integer userId =(Integer) session.getAttribute("userId");
		c.setUserId(userId);
		contactservice.saves(c);
		//c.setUserId(userId);//fk logged in userid
		return "redirect:clist?act=sv";//jsp
		
		}catch(Exception e) {
			e.printStackTrace();
			m.addAttribute("err", "failed to save contact");
			return "contact_form";
			
		}
	}
	

	@RequestMapping(value="/user/clist")
	public String contactList(Model m,HttpSession session)
	{   
	  Integer userId=(Integer) session.getAttribute("userId");
		m.addAttribute("contactList",contactservice.findUserContacts(userId));
		
		return "clist";//jsp		
	}
	
}
