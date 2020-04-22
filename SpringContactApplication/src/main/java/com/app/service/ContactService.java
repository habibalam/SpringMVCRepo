package com.app.service;

import java.util.List;

import com.app.domain.Contact;

public interface ContactService {

	
	 public void saves(Contact c);
	 public void updates(Contact c);
     public void deletes(Integer cotactId);
     public void deletes(Integer[] cotactIds); 
     public Contact findByIds(Integer cotactId);
     //This method returns all User Contact (user who is logged in).
     public List<Contact> findUserContacts(Integer userId);
     // The method search contact for user(userId) based on given free-text-criteria (txt)
     public List<Contact> findUserContacts(Integer userId, String txt);
     
     
	
}
