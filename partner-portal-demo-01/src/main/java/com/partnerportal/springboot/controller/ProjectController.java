package com.partnerportal.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.partnerportal.springboot.bean.ProjectBean;
import com.partnerportal.springboot.service.ProjectServiceImpl;
import com.partnerportal.springboot.utility.Constants;

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
		List<ProjectBean> projects = projectService.findAllProjects();
		model.addAttribute("projects", projects);

		return "/projects/list-projects";
	}

	//TODO: gestire tramite gestore delle anagrafiche (da implementare)
	@ResponseBody
	public String getDescState(int idStatus)
	{
		return Constants.getStateProjectMap().get(idStatus);
	}

	@GetMapping("/searchByProjectName")
	public String searchByProjectName(@RequestParam("projectName") String projectName, Model theModel)
	{
		List<ProjectBean> projectsList = projectService.searchByProjectName(projectName);
		theModel.addAttribute("projects", projectsList);
		return "/projects/list-projects";
	}
}
