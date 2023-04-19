package com.partnerportal.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partnerportal.springboot.bean.RelProjectPhaseBean;
import com.partnerportal.springboot.dao.ViewRelProjectPhaseDao;
import com.partnerportal.springboot.utility.EntityConverter;

@Service
public class PhaseProjectServiceImpl implements PhaseProjectServiceInterface
{

	private ViewRelProjectPhaseDao viewRelProjectPhaseDao;

	@Autowired
	public PhaseProjectServiceImpl(ViewRelProjectPhaseDao viewRelProjectPhaseDao)
	{
		this.viewRelProjectPhaseDao = viewRelProjectPhaseDao;
	}

	@Override
	public List<RelProjectPhaseBean> findAllProjectPhase()
	{
		return EntityConverter.generateRelProjectPhaseBeanList(viewRelProjectPhaseDao.findAll());
	}

	@Override
	public List<RelProjectPhaseBean> findPhaseOfThePrject(int idProject)
	{
		return EntityConverter.generateRelProjectPhaseBeanList(viewRelProjectPhaseDao.findPhaseOfTheProject(idProject));
	}

}
