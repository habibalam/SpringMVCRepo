package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.app.bo.EmployeeBO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
   
	private static final String GET_ALL_EMPS=" SELECT EMPNO,ENAME,JOB,ESAL,DEPTNO FROM EMP ";
	
	@Autowired
	private JdbcTemplate jt;
	
	/*
	 * public EmployeeDAOImpl(JdbcTemplate jt) {
	 * 
	 * this.jt = jt; System.out.println("Consturctor jdbcTemplet......."); }
	 */
	
	@Override
	public List<EmployeeBO> getAllEmployees() {
		List<EmployeeBO> listbo=null;
		System.out.println("get method called..........");
		listbo=jt.query( GET_ALL_EMPS, new EmployeeExtractor());
		System.out.println("get inside method....................."+listbo);
		
		System.out.println("print listtbo"+listbo);
		return listbo;
	}
	
	private class EmployeeExtractor implements ResultSetExtractor<List<EmployeeBO>>{

		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			//copy result object to add them to list collection
			List<EmployeeBO> listBO=null;
			EmployeeBO bo=null;
			listBO=new ArrayList();
			while(rs.next())
			{  
				//copy each record to bo class obj
				bo=new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setEsal(rs.getFloat(4));
				bo.setDeptNo(rs.getInt(5));
				listBO.add(bo);
			}// end while loop
			
			return listBO;
		}
		
	}

}
