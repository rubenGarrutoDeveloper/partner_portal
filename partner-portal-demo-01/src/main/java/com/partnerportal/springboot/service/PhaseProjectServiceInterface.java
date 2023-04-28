package com.partnerportal.springboot.service;

import java.util.List;

import com.partnerportal.springboot.bean.RelProjectPhaseBean;

public interface PhaseProjectServiceInterface
{
	public List<RelProjectPhaseBean> findAllProjectPhase(); // Find all phases 

	public List<RelProjectPhaseBean> findPhaseOfTheProject(int idProject); // Find all phases of a specific projects

	public void save(RelProjectPhaseBean newRelProjectPhaseBean);

	public void deletePhaseById(int idPhase); // Delete a phase based on ID

	public boolean deleteRelProjectPhase(int idProject, int idPhase); // Delete the relation between a  phase and a project based on ID

	public boolean deleteAllPhasesFromProject(int idProject);

	public void deletePhaseFromProject(int idProject, int idPhase); // Delete the relation between a  phase and a project and the phase itself
}
