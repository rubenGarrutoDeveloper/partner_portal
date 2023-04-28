package com.partnerportal.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.partnerportal.springboot.entity.ProjectPhase;

public interface ProjectPhaseDao extends JpaRepository<ProjectPhase, Integer>
{
	@Modifying
	@Transactional
	@Query("DELETE FROM ProjectPhase t WHERE t.id in :idPhaseList")
	public int deletePhasesByIdList(@Param("idPhaseList") List<Integer> idPhaseList);
}
