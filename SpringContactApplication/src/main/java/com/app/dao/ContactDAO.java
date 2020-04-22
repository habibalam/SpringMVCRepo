package com.app.dao;

import java.util.List;

import com.app.domain.Contact;

public interface ContactDAO {
	
	public void save(Contact c);
	public void update(Contact c);
	public void delete(Contact c);
	public void delete(Integer contactId);
	public Contact findByIdd(Integer contactId); 
    public List<Contact>findsAll();
    public List<Contact> findsByProperty(String propName,Object propValue);
    
    

}
