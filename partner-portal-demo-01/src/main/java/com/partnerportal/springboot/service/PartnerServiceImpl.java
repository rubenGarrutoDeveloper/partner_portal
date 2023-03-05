package com.partnerportal.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partnerportal.springboot.bean.PartnerBean;
import com.partnerportal.springboot.dao.ViewPartnerDao;
import com.partnerportal.springboot.utility.EntityConverter;

@Service
public class PartnerServiceImpl implements PartnerServiceInterface
{

	private ViewPartnerDao viewPartnerDao;

	@Autowired
	public PartnerServiceImpl(ViewPartnerDao viewPartnerDao)
	{
		this.viewPartnerDao = viewPartnerDao;
	}

	@Override
	public List<PartnerBean> findPartnersAssociatedToProject(int idProject)
	{
		return EntityConverter.generatePartnerBeanList(viewPartnerDao.findPartnersAssociatedToProject(idProject));
	}

	@Override
	public List<PartnerBean> findAllPartner()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartnerBean findById(int idProject)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PartnerBean> searchByPartnerName(String title)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(PartnerBean newPartner)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int idProject)
	{
		// TODO Auto-generated method stub

	}
}
