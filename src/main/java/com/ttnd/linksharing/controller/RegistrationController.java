package com.ttnd.linksharing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ttnd.linksharing.entity.User;
import com.ttnd.linksharing.service.impl.UserService;

@Controller
public class RegistrationController {
	
	/*
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute User user)
	{	
		System.out.println(user);
		UserService userService=new UserService();
		boolean valid=userService.isValid(user);
		if(valid)
		{
			ModelAndView modelAndView=new ModelAndView("welcome.jsp");
			return modelAndView;
					
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView("index");
			return modelAndView;
		}
		
	}*/
}
