package com.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.app.dto.EmployeeDTO;
import com.app.service.EmployeeMgmtService;

@Controller
public class ListEmployeeController  {

	@Autowired
	private EmployeeMgmtService service;
	
	/*
	 * public ListEmployeeController(EmployeeMgmtService service) {
	 * 
	 * this.service = service;
	 * 
	 * }
	 */
     @RequestMapping("/welcome.htm")
	public String showHome()
	{
		return "home";
		
	}

    @RequestMapping("/list_emps.htm")
	public String showEmps(Map<String,Object> map){
		// use service
		List<EmployeeDTO> listdto=null;
		listdto=service.fetchAllEmp();
		//map data in model attributs
		map.put("listdto", listdto);
		
		return "show_emps";
	}

}
