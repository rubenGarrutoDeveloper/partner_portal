package com.partnerportal.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController
{
	@GetMapping("/")
	public String goToHome()
	{
		return "home";
	}

	@GetMapping("/projects")
	public String goToGestioneProgetti()
	{
		return "projects";
	}

	@GetMapping("/systems")
	public String goToSystems()
	{
		return "systems";
	}

}
