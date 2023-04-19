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

import com.partnerportal.springboot.bean.PartnerBean;
import com.partnerportal.springboot.bean.ProjectBean;
import com.partnerportal.springboot.bean.RelProjectPhaseBean;
import com.partnerportal.springboot.entity.Project;
import com.partnerportal.springboot.service.PartnerServiceImpl;
import com.partnerportal.springboot.service.PhaseProjectServiceImpl;
import com.partnerportal.springboot.service.ProjectServiceImpl;
import com.partnerportal.springboot.utility.Constants;

@Controller
@RequestMapping("/projects")
public class ProjectController
{

	private final ProjectServiceImpl projectService;
	private final PartnerServiceImpl partnerServiceImpl;
	private final PhaseProjectServiceImpl phaseProjectServiceImpl;

	@Autowired
	public ProjectController(ProjectServiceImpl projectService, PartnerServiceImpl partnerServiceImpl, PhaseProjectServiceImpl phaseProjectServiceImpl)
	{
		this.projectService = projectService;
		this.partnerServiceImpl = partnerServiceImpl;
		this.phaseProjectServiceImpl = phaseProjectServiceImpl;
	}

	@GetMapping("/phase/list")
	public String getAllProjects(Model model)
	{
		List<RelProjectPhaseBean> projectsPhaseList = phaseProjectServiceImpl.findAllProjectPhase();
		model.addAttribute("projectsPhaseList", projectsPhaseList);

		return "/projects/projects-phase-list";
	}

	@GetMapping("/list")
	public String getAllProjectPhase(Model model)
	{
		List<ProjectBean> projects = projectService.findAllProjects();
		model.addAttribute("projects", projects);

		return "/projects/projects-list";
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
		return "/projects/projects-list";
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

	/**
	 * Retrieves the details of a project and its associated partners and project
	 * phases.
	 * 
	 * @param idProject the ID of the project to retrieve details for
	 * @param model     the model object to add the retrieved data to
	 * @return the view name for displaying the project details
	 */
	@GetMapping("/project-details")
	public String getPartnersByIdProject(@RequestParam("idProject") int idProject, Model model)
	{
		// Retrieve the project with the given ID
		ProjectBean projectSelected = projectService.findProjectBeanById(idProject);

		// Retrieve a list of partners associated with the project
		List<PartnerBean> partners = partnerServiceImpl.findPartnersAssociatedToProject(idProject);

		// Retrieve a list of project phases for the project
		List<RelProjectPhaseBean> projectPhaseList = phaseProjectServiceImpl.findPhaseOfThePrject(idProject);

		// Add the partners, project, and projectPhaseList to the model object to be displayed in the view
		model.addAttribute("partners", partners);
		model.addAttribute("project", projectSelected);
		model.addAttribute("projectPhaseList", projectPhaseList);

		// Return the view name for displaying the project details
		return "/projects/project-details";
	}

}
