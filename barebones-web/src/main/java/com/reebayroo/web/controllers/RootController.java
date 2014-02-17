package com.reebayroo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

	@RequestMapping({"/index", "/"})
	public String index() {
		return ".index";
	}
	@RequestMapping("/404")
	public String fourOfour() {
		return "404";
	}	
	@RequestMapping("/about")
	public String about() {
		return ".about";
	}	
}
