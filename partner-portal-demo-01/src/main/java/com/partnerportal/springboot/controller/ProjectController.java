package com.partnerportal.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.partnerportal.springboot.bean.ProjectBean;
import com.partnerportal.springboot.entity.Project;
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

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		ProjectBean newProject = new ProjectBean();
		theModel.addAttribute("project", newProject);
		return "/projects/project-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("projectId") int idProject, Model theModel)
	{
		Project projectToUpdate = projectService.findById(idProject);
		theModel.addAttribute("project", projectToUpdate);
		return "/projects/project-form";
	}

	@PostMapping("/save")
	public String saveProject(@ModelAttribute("project") ProjectBean newProject)
	{
		// save the new project
		projectService.save(newProject);

		// use a redirect to prevent duplicate submissions
		return "redirect:/projects/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("projectId") int idProject)
	{
		// delete the projects
		projectService.deleteById(idProject);

		// redirect to /employees/list
		return "redirect:/projects/list";

	}

}
