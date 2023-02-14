package com.partnerportal.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partnerportal.springboot.dao.ProjectDao;
import com.partnerportal.springboot.entity.Project;

@Service
public class ProjectServiceImpl implements ProjectServiceInterface
{
	private ProjectDao projectDao;

	@Autowired
	public ProjectServiceImpl(ProjectDao projectDao)
	{
		this.projectDao = projectDao;
	}

	@Override
	public List<Project> findAllProjects()
	{
		return projectDao.findAll();
	}

	@Override
	public Project findById(int idProject)
	{
		Optional<Project> queryResult = projectDao.findById(idProject);

		if(!queryResult.isPresent())
		{
			throw new RuntimeException("Did not find project id - " + idProject);

		}

		return queryResult.get();
	}

	@Override
	public void save(Project newProject)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteById(int idProject)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public List<Project> searchBy(String title)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
