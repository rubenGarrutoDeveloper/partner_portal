package com.partnerportal.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partnerportal.springboot.bean.RelProjectPhaseBean;
import com.partnerportal.springboot.dao.ProjectPhaseDao;
import com.partnerportal.springboot.dao.RelProjectPhaseDao;
import com.partnerportal.springboot.dao.ViewRelProjectPhaseDao;
import com.partnerportal.springboot.entity.ProjectPhase;
import com.partnerportal.springboot.entity.RelProjectPhase;
import com.partnerportal.springboot.utility.EntityConverter;

@Service
public class PhaseProjectServiceImpl implements PhaseProjectServiceInterface
{

	private ViewRelProjectPhaseDao viewRelProjectPhaseDao;
	private ProjectPhaseDao projectPhaseDao;
	private RelProjectPhaseDao relProjectPhaseDao;

	@Autowired
	public PhaseProjectServiceImpl(ViewRelProjectPhaseDao viewRelProjectPhaseDao, ProjectPhaseDao projectPhaseDao, RelProjectPhaseDao relProjectPhaseDao)
	{
		this.viewRelProjectPhaseDao = viewRelProjectPhaseDao;
		this.projectPhaseDao = projectPhaseDao;
		this.relProjectPhaseDao = relProjectPhaseDao;
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

	@Override
	public void save(RelProjectPhaseBean newRelProjectPhaseBean)
	{
		ProjectPhase projectPhase = new ProjectPhase();
		projectPhase.setTitle(newRelProjectPhaseBean.getTitle());
		projectPhase.setDescription(newRelProjectPhaseBean.getDescription());
		projectPhase.setStartTime(newRelProjectPhaseBean.getStartTime());
		projectPhase.setEndTime(newRelProjectPhaseBean.getEndTime());
		projectPhase.setFundRaised(newRelProjectPhaseBean.getFundRaised());
		projectPhase.setTotalFund(newRelProjectPhaseBean.getTotalFund());
		int idPhase = projectPhaseDao.save(projectPhase).getId();

		RelProjectPhase relProjectPhase = new RelProjectPhase();
		relProjectPhase.setIdPhase(idPhase);
		relProjectPhase.setIdProject(newRelProjectPhaseBean.getIdProject());

		relProjectPhaseDao.save(relProjectPhase);

	}

}
