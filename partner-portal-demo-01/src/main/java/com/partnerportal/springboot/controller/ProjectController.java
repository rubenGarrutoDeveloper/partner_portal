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
import com.partnerportal.springboot.bean.RelProjectPhaseBean;
import com.partnerportal.springboot.bean.UserBean;
import com.partnerportal.springboot.entity.Project;
import com.partnerportal.springboot.service.PhaseProjectServiceImpl;
import com.partnerportal.springboot.service.ProjectServiceImpl;
import com.partnerportal.springboot.service.UserServiceImpl;
import com.partnerportal.springboot.utility.Constants;

@Controller
@RequestMapping("/projects")
public class ProjectController
{
	private final ProjectServiceImpl projectService;
	private final PhaseProjectServiceImpl phaseProjectService;
	private final UserServiceImpl userService;

	@Autowired
	public ProjectController(ProjectServiceImpl projectService, PhaseProjectServiceImpl phaseProjectService, UserServiceImpl userService)
	{
		this.projectService = projectService;
		this.phaseProjectService = phaseProjectService;
		this.userService = userService;
	}

	// PROJECT MANAGEMENT SECTION ------------------------------------------------------------------------------------------------------------------------------------
	@GetMapping("/list")
	public String getAllProjects(Model model)
	{
		List<ProjectBean> projects = projectService.findAllProjects();
		model.addAttribute("projects", projects);

		return "/projects/projects-list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("projectId") int idProject, Model theModel)
	{
		Project projectToUpdate = projectService.findById(idProject);
		theModel.addAttribute("project", projectToUpdate);
		return "/projects/project-form";
	}

	@PostMapping("/saveProject")
	public String saveProject(@ModelAttribute("project") ProjectBean newProject)
	{
		// save the new project
		projectService.save(newProject);

		// use a redirect to prevent duplicate submissions
		return "redirect:/projects/list";
	}

	@GetMapping("/delete/project")
	public String deleteProject(@RequestParam("projectId") int idProject)
	{
		// Delete all the phases related to the project
		phaseProjectService.deleteAllPhasesFromProject(idProject);

		// delete the project 
		projectService.deleteById(idProject);

		// redirect
		return "redirect:/projects/list";
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

	@GetMapping("/addNewProject")
	public String addNewProject(Model theModel)
	{
		ProjectBean newProject = new ProjectBean();
		theModel.addAttribute("project", newProject);
		return "/projects/project-form";
	}

	// PHASE MANAGEMENT SECTION ------------------------------------------------------------------------------------------------------------------------------------
	@GetMapping("/phase/list")
	public String getAllProjectPhase(Model model)
	{
		List<RelProjectPhaseBean> projectsPhaseList = phaseProjectService.findAllProjectPhase();
		model.addAttribute("projectsPhaseList", projectsPhaseList);

		return "/projects/projects-phase-list";
	}

	@GetMapping("/addNewPhase")
	public String addNewPhase(Model theModel, @RequestParam("idProject") int idProject)
	{
		RelProjectPhaseBean newRelProjectPhaseBean = new RelProjectPhaseBean(idProject);

		theModel.addAttribute("newRelProjectPhaseBean", newRelProjectPhaseBean);
		return "/projects/project-phase-form";
	}

	@GetMapping("/delete/phase")
	public String deletePhase(@RequestParam("idProject") int idProject, @RequestParam("idPhase") int idPhase, Model model)
	{
		// delete phase associated to the project
		phaseProjectService.deletePhaseFromProject(idProject, idPhase);

		return showProjectDetails(idProject, model);
	}

	@PostMapping("/savePhaseForTheProject")
	public String savePhase(@ModelAttribute("newRelProjectPhaseBean") RelProjectPhaseBean newRelProjectPhaseBean, Model model)
	{
		// save the new phase
		phaseProjectService.save(newRelProjectPhaseBean);

		// use a redirect to prevent duplicate submissions
		return showProjectDetails(newRelProjectPhaseBean.getIdProject(), model);
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
	public String showProjectDetails(@RequestParam("idProject") int idProject, Model model)
	{
		// Retrieve the project with the given ID
		ProjectBean projectSelected = projectService.findProjectBeanById(idProject);

		// Retrieve a list of partners associated with the project
		List<UserBean> users = userService.findUsersAssociatedToProject(idProject);

		// Retrieve a list of project phases for the project
		List<RelProjectPhaseBean> projectPhaseList = phaseProjectService.findPhaseOfTheProject(idProject);

		// Add the partners, project, and projectPhaseList to the model object to be displayed in the view
		model.addAttribute("users", users);
		model.addAttribute("project", projectSelected);
		model.addAttribute("projectPhaseList", projectPhaseList);

		// Return the view name for displaying the project details
		return "/projects/project-details";
	}

	@GetMapping("/donate")
	public String goToDonatePage(@RequestParam("idProject") int idProject, Model model)
	{
		return "/projects/donate";
	}

}
