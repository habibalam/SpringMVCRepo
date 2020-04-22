package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bo.EmployeeBO;
import com.app.dao.EmployeeDAO;
import com.app.dto.EmployeeDTO;

@Service("/empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
 
	@Autowired
	private EmployeeDAO empdao;
	
	/*
	 * public EmployeeMgmtServiceImpl(EmployeeDAO empdao) { this.empdao = empdao; }
	 */

	@Override
	public List<EmployeeDTO> fetchAllEmp() {
		List<EmployeeBO> listbo=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		// use dao
		listbo=empdao.getAllEmployees();
		//convert listBO to listDTO
		listbo.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		
		return listDTO;
	}//method

}//class
