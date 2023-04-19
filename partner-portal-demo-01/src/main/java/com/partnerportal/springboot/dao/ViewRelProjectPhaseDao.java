package com.partnerportal.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.partnerportal.springboot.entity.ViewRelProjectPhase;

public interface ViewRelProjectPhaseDao extends JpaRepository<ViewRelProjectPhase, Integer>
{
	@Query("SELECT vp FROM ViewRelProjectPhase vp WHERE vp.idProject = :idProject")
	public List<ViewRelProjectPhase> findPhaseOfTheProject(@Param("idProject") int idProject);

}
