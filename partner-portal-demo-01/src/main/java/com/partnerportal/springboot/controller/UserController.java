package com.partnerportal.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.partnerportal.springboot.entity.User;
import com.partnerportal.springboot.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController
{
	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/showUserDetailForm")
	public String showMyLoginPage(Model theModel)
	{
		User loggedUser = userService.getLoggedUser();

		theModel.addAttribute("loggedUser", loggedUser);

		return "users/user-details";
	}

	@PostMapping("/updateLoggedUser")
	public String updateLoggedUser(Model theModel)
	{
		return "redirect:/users/showUserDetailForm";
	}

}
