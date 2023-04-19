package com.partnerportal.springboot.service;

import java.util.List;

import com.partnerportal.springboot.bean.RelProjectPhaseBean;

public interface PhaseProjectServiceInterface
{
	public List<RelProjectPhaseBean> findAllProjectPhase(); // Find all phases 

	public List<RelProjectPhaseBean> findPhaseOfThePrject(int idProject); // Find all phases of a specific projects
}
