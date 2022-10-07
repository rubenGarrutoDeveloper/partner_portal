package com.partnerportal.demo.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{
	@GetMapping("/login")
	public String gotToLogin()
	{
		return "partner-portal-login";
	}

	@GetMapping("/access-denied")
	public String goToAccessDenied()
	{
		return "access-denied";
	}
}