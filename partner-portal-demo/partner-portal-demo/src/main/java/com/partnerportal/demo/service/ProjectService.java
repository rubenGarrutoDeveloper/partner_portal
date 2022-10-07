package com.partnerportal.demo.service;

import java.util.List;

import com.partnerportal.demo.entity.Project;

public interface ProjectService
{

	public List<Project> getAllProjects();

	public void saveProject(Project theProject);

	public Project getProject(int theId);

	public void deleteProject(int theId);

}
