package com.app.dao;



import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.app.domain.Contact;
import com.app.domain.User;
import com.app.exception.UserBlockException;

abstract public class BaseDAO extends NamedParameterJdbcDaoSupport{
    
	@Autowired
	public void setDataSorce(DataSource ds)
	{
		
		super.setDataSource(ds);
	}
    
	
	public void save(User u) {
		// TODO Auto-generated method stub
		
	}


	public void update(User u) {
		// TODO Auto-generated method stub
		
	}


	public void delete(Integer userId) {
		// TODO Auto-generated method stub
		
	}


	public void delete(User u) {
		// TODO Auto-generated method stub
		
	}


	public User findById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<User> findByProperty(String propName, Object propValue) {
		// TODO Auto-generated method stub
		return null;
	}


	public void save(Contact c) {
		// TODO Auto-generated method stub
		
	}


	public void update(Contact c) {
		// TODO Auto-generated method stub
		
	}


	public void delete(Contact c) {
		// TODO Auto-generated method stub
		
	}


	public Contact findByIdd(Integer contactId) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Contact> findsAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Contact> findsByProperty(String propName, Object propValue) {
		// TODO Auto-generated method stub
		return null;
	}


	public void register(User u) {
		// TODO Auto-generated method stub
		
	}


	public void saves(Contact c) {
		// TODO Auto-generated method stub
		
	}


	public void updates(Contact c) {
		// TODO Auto-generated method stub
		
	}


	public void deletes(Integer cotactId) {
		// TODO Auto-generated method stub
		
	}


	public Contact findByIds(Integer cotactId) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Contact> findUserContacts(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Contact> findUserContacts(Integer userId, String txt) {
		// TODO Auto-generated method stub
		return null;
	}


	public User login(String loginName, String password) throws UserBlockException {
		// TODO Auto-generated method stub
		return null;
	}


	


	
	 
}
