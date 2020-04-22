package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BaseDAO;
import com.app.dao.ContactDAO;
import com.app.domain.Contact;
import com.app.rm.ContactRowMapper;
import com.app.utility.StringUtility;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService{
    
	@Autowired
	private ContactDAO contactDAO;
	
	@Override
	public void saves(Contact c) {
		contactDAO.save(c);
		
	}
    
	@Override
	public void updates(Contact c) {
		contactDAO.update(c);
		
	}
    
	@Override
	public void deletes(Integer cotactId) {
	
	  contactDAO.delete(cotactId);
	}

	public void deletes(Integer[] cotactIds) {
		String ids = StringUtility.toCommaSeparatedString(cotactIds);
        String sql = "DELETE FROM contact WHERE contactId IN("+ids+")";
        getJdbcTemplate().update(sql);
		
	}
    
	@Override
	public Contact findByIds(Integer cotactId) {
		 return contactDAO.findByIdd(cotactId);
	}
    @Override
	public List<Contact> findUserContacts(Integer userId) {
		
     return contactDAO.findsByProperty("userId",userId);
	}
    
    @Override
	public List<Contact> findUserContacts(Integer userId, String txt) {
		String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE userId=? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
        return getJdbcTemplate().query(sql, new ContactRowMapper(),userId); 
	}

	

}
