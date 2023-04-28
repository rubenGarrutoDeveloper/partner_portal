package com.partnerportal.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.partnerportal.springboot.entity.RelProjectPhase;

public interface RelProjectPhaseDao extends JpaRepository<RelProjectPhase, Integer>
{

	@Query("SELECT vp FROM RelProjectPhase vp WHERE vp.idProject = :idProject")
	public List<RelProjectPhase> findPhaseOfTheProject(@Param("idProject") int idProject);

	@Modifying
	@Transactional
	@Query("DELETE FROM RelProjectPhase t WHERE t.idProject = :idProject AND t.idPhase = :idPhase")
	public int deleteRelProjectPhase(@Param("idProject") int idProject, @Param("idPhase") int idPhase);

	@Modifying
	@Transactional
	@Query("DELETE FROM RelProjectPhase t WHERE t.idProject = :idProject")
	public int deleteAllPhasesFromProject(@Param("idProject") int idProject);

}
