package com.partnerportal.springboot.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partnerportal.springboot.bean.ProjectBean;
import com.partnerportal.springboot.dao.AnagStatusDao;
import com.partnerportal.springboot.dao.ProjectDao;
import com.partnerportal.springboot.dao.UserDao;
import com.partnerportal.springboot.dao.ViewProjectDao;
import com.partnerportal.springboot.entity.Project;
import com.partnerportal.springboot.utility.Constants;
import com.partnerportal.springboot.utility.EntityConverter;

@Service
public class ProjectServiceImpl implements ProjectServiceInterface
{
	private ProjectDao projectDao;

	private ViewProjectDao viewProjectDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private AnagStatusDao anagStatusDao;

	@Autowired
	public ProjectServiceImpl(ProjectDao projectDao, ViewProjectDao viewProjectDao)
	{
		this.projectDao = projectDao;
		this.viewProjectDao = viewProjectDao;
	}

	@Override
	public List<ProjectBean> findAllProjects()
	{
		return EntityConverter.generateProjectBeanList(viewProjectDao.findAllByOrderByDateLastStateDesc());
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
	public List<ProjectBean> searchByProjectName(String title)
	{
		return EntityConverter.generateProjectBeanList(viewProjectDao.findByTitleContaining(title));
	}

	@Override
	/**
	 * Saves a new project in the database.
	 * 
	 * @param newProjectBean the bean containing the data of the new project to save
	 */
	public void save(ProjectBean newProjectBean)
	{

		// Convert the project bean into a project entity
		Project projectToSave = EntityConverter.generateProjectEntity(newProjectBean);

		// Set the created by user ID to the ID of the currently logged in user
		projectToSave.setCreatedBy(userDao.getLoggedUser().getId());

		// Set the project status to "Started"
		projectToSave.setProjectStatus(Arrays.asList(anagStatusDao.findStatusByID(Constants.ID_STATUS_STARTED)));

		// Save the project in the database
		projectDao.save(projectToSave);
	}

	@Override
	public void deleteById(int idProject)
	{
		// TODO Auto-generated method stub
	}
}
