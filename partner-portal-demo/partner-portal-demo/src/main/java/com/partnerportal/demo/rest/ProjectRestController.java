package com.partnerportal.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.partnerportal.demo.entity.Project;
import com.partnerportal.demo.service.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectRestController
{

	// autowire the CustomerService
	@Autowired
	private ProjectService projectService;

	// add mapping for GET /customers
	@GetMapping("/projects")
	public List<Project> getProjects()
	{
		return projectService.getAllProjects();
	}

}
