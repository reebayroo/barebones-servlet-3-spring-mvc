package com.reebayroo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@RequestMapping(method=RequestMethod.GET, value={"/", "list"})
	public ModelAndView users(){
		
		final ModelAndView result = new ModelAndView(".users.list");
		return result;
	}
	@RequestMapping(method=RequestMethod.GET, value={"new"})
	public ModelAndView newUser(){
		final ModelAndView result = new ModelAndView(".users.edit");
		return result;
	}
	
}
