package com.partnerportal.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partnerportal.springboot.bean.ProjectBean;
import com.partnerportal.springboot.dao.ProjectDao;
import com.partnerportal.springboot.dao.ViewProjectDao;
import com.partnerportal.springboot.entity.Project;
import com.partnerportal.springboot.utility.EntityConverter;

@Service
public class ProjectServiceImpl implements ProjectServiceInterface
{
	private ProjectDao projectDao;

	private ViewProjectDao viewProjectDao;

	@Autowired
	public ProjectServiceImpl(ProjectDao projectDao, ViewProjectDao viewProjectDao)
	{
		this.projectDao = projectDao;
		this.viewProjectDao = viewProjectDao;
	}

	@Override
	public List<ProjectBean> findAllProjects()
	{
		return EntityConverter.generateProjectBeanList(viewProjectDao.findAll());
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
