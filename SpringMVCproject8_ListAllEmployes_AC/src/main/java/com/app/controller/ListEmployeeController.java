package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.app.dto.EmployeeDTO;
import com.app.service.EmployeeMgmtService;

public class ListEmployeeController extends AbstractController {

	private EmployeeMgmtService service;
	
	public ListEmployeeController(EmployeeMgmtService service) {
		
		this.service = service;
		
	}


	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// use service
		List<EmployeeDTO> listdto=null;
		listdto=service.fetchAllEmp();
		
		return new ModelAndView("show_emps","listdto",listdto);
	}

}
