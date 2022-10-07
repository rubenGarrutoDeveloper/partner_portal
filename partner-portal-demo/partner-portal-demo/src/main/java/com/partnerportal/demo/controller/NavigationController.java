package com.partnerportal.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController
{
	private final String admin = "admin";
	private final String projectsSection = "projects-section";

	@GetMapping("/")
	public String goToHome()
	{
		return "home";
	}

	@GetMapping("/" + projectsSection + "/projects")
	public String goToGestioneProgetti()
	{
		return projectsSection + "/projects";
	}

	@GetMapping("/" + admin + "/systems")
	public String goToSystems()
	{
		return admin + "/systems";
	}

}
