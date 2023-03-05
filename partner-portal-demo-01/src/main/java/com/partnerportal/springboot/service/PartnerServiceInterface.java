package com.partnerportal.springboot.service;

import java.util.List;

import com.partnerportal.springboot.bean.PartnerBean;

public interface PartnerServiceInterface
{
	public List<PartnerBean> findAllPartner(); // Find all partner

	public PartnerBean findById(int idProject); // Find a partner based on ID

	public List<PartnerBean> searchByPartnerName(String title); // Find a partner based on title

	public void save(PartnerBean newPartner); // Save a partner

	public void deleteById(int idPartner); // Delete a partner based on ID

	public List<PartnerBean> findPartnersAssociatedToProject(int idProject);
}
