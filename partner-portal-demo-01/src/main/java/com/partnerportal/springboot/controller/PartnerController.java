package com.partnerportal.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.partnerportal.springboot.bean.PartnerBean;
import com.partnerportal.springboot.service.PartnerServiceImpl;

@Controller
@RequestMapping("/partners")
public class PartnerController
{

	private final PartnerServiceImpl partnerServiceImpl;

	@Autowired
	public PartnerController(PartnerServiceImpl partnerServiceImpl)
	{
		this.partnerServiceImpl = partnerServiceImpl;
	}

	@GetMapping("/partners-associated")
	public String getPartnersByIdProject(@RequestParam("idProject") int idProject, Model model)
	{
		List<PartnerBean> partners = partnerServiceImpl.findPartnersAssociatedToProject(idProject);
		model.addAttribute("partners", partners);
		return "/partners/list-partners";
	}

}
