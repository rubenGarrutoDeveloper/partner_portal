package com.partnerportal.springboot.service;

import java.util.List;

import com.partnerportal.springboot.bean.ProjectBean;
import com.partnerportal.springboot.entity.Project;

public interface ProjectServiceInterface
{
	public List<ProjectBean> findAllProjects(); // Find all projects

	public Project findById(int idProject); // Find a project based on ID

	public List<Project> searchBy(String title); // Find a project based on title

	public void save(Project newProject); // Save a project

	public void deleteById(int idProject); // Delete a project based on ID
}