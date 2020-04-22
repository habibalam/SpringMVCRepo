package com.app.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WishMessageController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Calendar cal=null;
		String msg=null;
		int hour=0;
		//get system date
		cal=Calendar.getInstance();
		//get hour
		hour=cal.get(Calendar.HOUR_OF_DAY);
		if(hour<12)
			msg= "Good morning";
		else if(hour<16)
			msg="Good Afternoon";
		else if(hour<20)
			msg="good evening";
		else msg="Good night";
		
		return new ModelAndView("result","resMsg",msg);
	}

}
