package com.partnerportal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.partnerportal.demo.dao.ProjectDAO;
import com.partnerportal.demo.entity.Project;

@Service
public class ProjectServiceImpl implements ProjectService
{

	// need to inject project dao
	@Autowired
	private ProjectDAO projectDAO;

	@Override
	@Transactional
	public List<Project> getAllProjects()
	{
		return projectDAO.getAllProjects();
	}

	@Override
	@Transactional
	public void saveProject(Project theProject)
	{
		projectDAO.saveProject(theProject);
	}

	@Override
	@Transactional
	public Project getProject(int theId)
	{
		return projectDAO.getProject(theId);
	}

	@Override
	@Transactional
	public void deleteProject(int theId)
	{
		projectDAO.deleteProject(theId);
	}
}
