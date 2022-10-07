package com.partnerportal.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.partnerportal.demo.entity.Project;

@Repository
public class ProjectDAOImpl implements ProjectDAO
{

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Project> getAllProjects()
	{

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query  ... sort by last name
		Query<Project> theQuery = currentSession.createQuery("from Project order by id", Project.class);

		// execute query and get result list
		List<Project> projects = theQuery.getResultList();

		// return the results		
		return projects;
	}

	@Override
	public void saveProject(Project theProject)
	{

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theProject);

	}

	@Override
	public Project getProject(int theId)
	{

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Project theProject = currentSession.get(Project.class, theId);

		return theProject;
	}

	@Override
	public void deleteProject(int theId)
	{

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Project where id=:projectId");
		theQuery.setParameter("projectId", theId);

		theQuery.executeUpdate();
	}

}
