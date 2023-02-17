package com.partnerportal.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{

	@GetMapping("/login")
	public String showLoginPage()
	{
		return "login";
	}

	@GetMapping("/public-page")
	public String showPublicPage()
	{
		return "public-page";
	}

	// add request mapping for /access-denied

	@GetMapping("/access-denied")
	public String showAccessDenied()
	{
		return "access-denied";
	}

}