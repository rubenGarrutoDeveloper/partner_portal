package com.partnerportal.springboot.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.partnerportal.springboot.entity.User;
import com.partnerportal.springboot.service.UserService;
import com.partnerportal.springboot.user.CrmUser;
import com.partnerportal.springboot.utility.Constants;

@Controller
@RequestMapping("/register")
public class RegistrationController
{

	@Autowired
	private UserService userService;

	private Logger logger = Logger.getLogger(getClass().getName());

	@InitBinder
	public void initBinder(WebDataBinder dataBinder)
	{

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel)
	{

		theModel.addAttribute("crmUser", new CrmUser());

		return "registration-form";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser theCrmUser, BindingResult theBindingResult, Model theModel)
	{

		String userName = theCrmUser.getUserName();
		logger.info("Processing registration form for: " + userName);

		// form validation
		if(theBindingResult.hasErrors())
		{
			return "registration-form";
		}

		// check the database if user already exists
		User existing = userService.findByUserName(userName);
		if(existing != null)
		{
			theModel.addAttribute("crmUser", new CrmUser());
			theModel.addAttribute("registrationError", "User name already exists.");

			logger.warning("User name already exists.");
			return "registration-form";
		}

		// create user account        						
		Integer idNewUser = userService.save(theCrmUser);

		// Assign default role 
		if(idNewUser != null)
			userService.assignRoleToUser(idNewUser, Constants.ID_ROLE_USER);

		logger.info("Successfully created user: " + userName);

		return "registration-confirmation";
	}
}
