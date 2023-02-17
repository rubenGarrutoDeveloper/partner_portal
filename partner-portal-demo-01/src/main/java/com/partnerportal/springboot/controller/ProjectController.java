package com.partnerportal.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.partnerportal.springboot.entity.Project;
import com.partnerportal.springboot.service.ProjectServiceImpl;

@Controller
@RequestMapping("/projects")
public class ProjectController
{

	private final ProjectServiceImpl projectService;

	@Autowired
	public ProjectController(ProjectServiceImpl projectService)
	{
		this.projectService = projectService;
	}

	@GetMapping("/list")
	public String getAllProjects(Model model)
	{
		List<Project> projects = projectService.findAllProjects();
		model.addAttribute("projects", projects);

		return "/projects/list-projects";
	}
}
