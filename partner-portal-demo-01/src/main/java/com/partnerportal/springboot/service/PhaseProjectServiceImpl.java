package com.partnerportal.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partnerportal.springboot.bean.RelProjectPhaseBean;
import com.partnerportal.springboot.dao.ProjectPhaseDao;
import com.partnerportal.springboot.dao.RelProjectPhaseDao;
import com.partnerportal.springboot.dao.ViewRelProjectPhaseDao;
import com.partnerportal.springboot.entity.ProjectPhase;
import com.partnerportal.springboot.entity.RelProjectPhase;
import com.partnerportal.springboot.utility.EntityConverter;
import com.partnerportal.springboot.utility.EntityTools;

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
	public List<RelProjectPhaseBean> findPhaseOfTheProject(int idProject)
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

	@Override
	public void deletePhaseById(int idPhase)
	{
		projectPhaseDao.deleteById(idPhase);
	}

	@Override
	public boolean deleteRelProjectPhase(int idProject, int idPhase)
	{
		int rowDeleted = relProjectPhaseDao.deleteRelProjectPhase(idProject, idPhase);

		return (rowDeleted == 0) ? false : true;
	}

	@Override
	public void deletePhaseFromProject(int idProject, int idPhase)
	{
		deleteRelProjectPhase(idProject, idPhase);
		deletePhaseById(idPhase);
	}

	/**
	 * Deletes all project phases and their relationships with the specified
	 * project.
	 *
	 * @param idProject the id of the project to delete phases from
	 * @return true if any project phases were deleted, false otherwise
	 */
	@Transactional
	@Override
	public boolean deleteAllPhasesFromProject(int idProject)
	{
		// Extract the ids of all project phases associated with the specified project
		List<Integer> idPhaseList = EntityTools.extractIdPhases(relProjectPhaseDao.findPhaseOfTheProject(idProject));

		// Delete all relationships between the project and its phases
		int rowDeleted = relProjectPhaseDao.deleteAllPhasesFromProject(idProject);

		// Delete all phases previously associated with the specified project
		if(rowDeleted > 0)
			rowDeleted = rowDeleted + projectPhaseDao.deletePhasesByIdList(idPhaseList);

		// Return true if any project phases were deleted, false otherwise
		return (rowDeleted == 0) ? false : true;
	}

}
