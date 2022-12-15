package com.partnerportal.springboot.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.partnerportal.springboot.dao.ProjectDAO;
import com.partnerportal.springboot.entity.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	
	private ProjectDAO projectDAO;
	
	@GetMapping("/list")
	public String getAllProject(Model theModel) {
		
		// get employees from db
		Iterable<Project> projects = projectDAO.findAll();
		
		// add to the spring model
		theModel.addAttribute("projects", projects);
		
		return "/project/list-project";
	}

	@GetMapping("/byid")
	public String getProjectById(@RequestParam("projectID")Integer projectID,Model theModel) {
		Optional<Project> project = projectDAO.findById(projectID);
		theModel.addAttribute("project",project);
		return "/project/single-project";
	}
	
	@PostMapping("/save")
	public String saveProject(@ModelAttribute("project") Project project) {
		
		// save the employee
		projectDAO.save(project);
		
		// use a redirect to prevent duplicate submissions
		return "project/create";
	}
	
	@DeleteMapping("/delete")
	public String deleteProject(@RequestParam("projectID")Integer projectID) {
		projectDAO.deleteById(projectID);
		return "project/deleted";
	}
	@PutMapping("/update")
	public Optional<Project> updateProject(@ModelAttribute("project") Project project){
		projectDAO.save(project);
		Optional<Project> updatedProject = projectDAO.findById(project.getProjectID());
		return updatedProject;
	}
}
