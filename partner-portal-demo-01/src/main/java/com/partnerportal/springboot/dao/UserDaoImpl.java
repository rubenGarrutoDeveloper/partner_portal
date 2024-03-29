package com.partnerportal.springboot.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.partnerportal.springboot.entity.User;

@Repository
public class UserDaoImpl implements UserDao
{

	@Autowired
	private EntityManager entityManager;

	@Override
	public User findByUserName(String theUserName)
	{
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using username
		Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
		theQuery.setParameter("uName", theUserName);
		User theUser = null;
		try
		{
			theUser = theQuery.getSingleResult();
		}
		catch(Exception e)
		{
			theUser = null;
		}

		return theUser;
	}

	@Override
	public Integer save(User theUser)
	{
		try
		{
			// get current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);

			currentSession.saveOrUpdate(theUser);

			return theUser.getId();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User getLoggedUser()
	{
		return findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
	}

}
