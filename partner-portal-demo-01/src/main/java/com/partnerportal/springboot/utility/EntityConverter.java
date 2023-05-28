package com.partnerportal.springboot.utility;

import java.util.ArrayList;
import java.util.List;

import com.partnerportal.springboot.bean.ProjectBean;
import com.partnerportal.springboot.bean.RelProjectPhaseBean;
import com.partnerportal.springboot.bean.UserBean;
import com.partnerportal.springboot.entity.Project;
import com.partnerportal.springboot.entity.ViewProject;
import com.partnerportal.springboot.entity.ViewRelProjectPhase;
import com.partnerportal.springboot.entity.ViewRelProjectUser;

public class EntityConverter
{
	public static RelProjectPhaseBean generateRelProjectPhaseBean(ViewRelProjectPhase viewRelProjectPhase)
	{
		RelProjectPhaseBean relProjectPhaseBean = new RelProjectPhaseBean();

		relProjectPhaseBean.setIdProject(viewRelProjectPhase.getIdProject());
		relProjectPhaseBean.setIdPhase(viewRelProjectPhase.getIdPhase());
		relProjectPhaseBean.setTitle(viewRelProjectPhase.getTitle());
		relProjectPhaseBean.setDescription(viewRelProjectPhase.getDescription());
		relProjectPhaseBean.setStartTime(viewRelProjectPhase.getStartTime());
		relProjectPhaseBean.setEndTime(viewRelProjectPhase.getEndTime());
		relProjectPhaseBean.setFundRaised(viewRelProjectPhase.getFundRaised());
		relProjectPhaseBean.setTotalFund(viewRelProjectPhase.getTotalFund());

		return relProjectPhaseBean;
	}

	public static List<RelProjectPhaseBean> generateRelProjectPhaseBeanList(List<ViewRelProjectPhase> viewRelProjectPhases)
	{
		List<RelProjectPhaseBean> relProjectPhaseBeans = new ArrayList<>();
		for(ViewRelProjectPhase viewRelProjectPhase : viewRelProjectPhases)
		{
			RelProjectPhaseBean relProjectPhaseBean = generateRelProjectPhaseBean(viewRelProjectPhase);
			relProjectPhaseBeans.add(relProjectPhaseBean);
		}
		return relProjectPhaseBeans;
	}

	public static List<ProjectBean> generateProjectBeanList(List<ViewProject> entityList)
	{
		List<ProjectBean> beanList = new ArrayList<ProjectBean>();

		if(Tools.isNullOrEmpty(entityList))
			return beanList;

		entityList.forEach(entity -> beanList.add(generateProjectBean(entity)));

		return beanList;
	}

	public static ProjectBean generateProjectBean(ViewProject entity)
	{
		ProjectBean bean = new ProjectBean();

		if(entity == null)
			return bean;

		bean.setIdProject(entity.getIdProject());
		bean.setCodeProject(entity.getCodeProject());
		bean.setTitle(entity.getTitle());
		bean.setDescProject(entity.getDescProject());
		bean.setIdStatus(entity.getAnagStatus().getIdStatus());
		bean.setCreatedBy(entity.getCreatedBy());
		bean.setNameCreatedBy(entity.getNameCreatedBy());
		bean.setDateLastState(entity.getDateLastState());

		return bean;
	}

	public static Project generateProjectEntity(ProjectBean bean)
	{
		if(bean == null)
			return new Project();

		Project entity = new Project();

		entity.setIdProject(bean.getIdProject());
		entity.setTitle(bean.getTitle());
		entity.setDescProject(bean.getDescProject());
		entity.setCodeProject(bean.getCodeProject());
		entity.setCreatedBy(bean.getCreatedBy());

		return entity;
	}

	public static List<UserBean> generateRelUserProjectBeanList(List<ViewRelProjectUser> entityList)
	{
		List<UserBean> beanList = new ArrayList<UserBean>();

		if(Tools.isNullOrEmpty(entityList))
			return beanList;

		entityList.forEach(entity -> beanList.add(generateUserBean(entity)));

		return beanList;
	}

	public static UserBean generateUserBean(ViewRelProjectUser entity)
	{
		UserBean bean = new UserBean();

		if(entity == null)
			return bean;

		bean.setFirstName(entity.getFirstName());
		bean.setLastName(entity.getLastName());
		bean.setEmail(entity.getEmail());

		return bean;
	}
}
