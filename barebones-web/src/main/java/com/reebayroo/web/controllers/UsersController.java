package com.reebayroo.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reebayroo.persistence.domain.User;
import com.reebayroo.service.IUserService;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(method=RequestMethod.GET, value={"/", "list"})
	public ModelAndView users(){
		
		final ModelAndView result = new ModelAndView(".users.list");
		return result;
	}
	@RequestMapping(method=RequestMethod.GET, value={"new"})
	public ModelAndView newUser(){
		final User user = new User();
		return editView(user);
	}
	private ModelAndView editView(final User user) {
		final ModelAndView result = new ModelAndView(".users.edit");
		result.addObject("command", user);
		return result;
	}
	@RequestMapping(method=RequestMethod.POST, value={"save"})
	public ModelAndView save(@ModelAttribute("user") final User user){
		try{
			this.userService.save(user);
			return ViewUtil.addSuccessMessage( editView(user) );
		} catch (final Exception ex){
			return ViewUtil.addError(editView(user), "Error saving user: %s", ex.getMessage());
		}
		
	}
	
	
	
	
}
