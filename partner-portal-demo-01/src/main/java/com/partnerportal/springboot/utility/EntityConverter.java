package com.partnerportal.springboot.utility;

import java.util.ArrayList;
import java.util.List;

import com.partnerportal.springboot.bean.ProjectBean;
import com.partnerportal.springboot.entity.ViewProject;

public class EntityConverter
{
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
		bean.setIdStatus(entity.getIdStatus());
		bean.setCreatedBy(entity.getCreatedBy());
		bean.setNameCreatedBy(entity.getNameCreatedBy());
		bean.setDateLastState(entity.getDateLastState());

		return bean;
	}
}
