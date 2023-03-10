package com.partnerportal.springboot.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.partnerportal.springboot.entity.AnagStatus;

@Repository
public class AnagStatusDaoImpl implements AnagStatusDao
{

	@Autowired
	private EntityManager entityManager;

	@Override
	public AnagStatus findStatusByID(int idStatus)
	{
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using name
		Query<AnagStatus> theQuery = currentSession.createQuery("from AnagStatus where idStatus=:idStatus", AnagStatus.class);
		theQuery.setParameter("idStatus", idStatus);

		AnagStatus anagStatus = null;

		try
		{
			anagStatus = theQuery.getSingleResult();
		}
		catch(Exception e)
		{
			anagStatus = null;
		}

		return anagStatus;
	}
}
