package com.partnerportal.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

	// create a mapping for "/hello"
	
	@GetMapping("/hello")
	public String sayHello(Model theModel) 
	{
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return "helloworld";
	}
	
	@GetMapping("/")
	public String showHome() 
	{
		return "home";
	}
	
	// add request mapping for /projects
	@GetMapping("/projects")
	public String showProjects() 
	{
		return "projects";
	}
	
	// add request mapping for /systems
	@GetMapping("/systems")
	public String showSystems() 
	{
		return "systems";
	}
}








