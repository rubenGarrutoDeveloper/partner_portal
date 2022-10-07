package com.partnerportal.demo.dao;

import java.util.List;

import com.partnerportal.demo.entity.Project;

public interface ProjectDAO
{

	public List<Project> getAllProjects();

	public void saveProject(Project theCustomer);

	public Project getProject(int theId);

	public void deleteProject(int theId);

}
