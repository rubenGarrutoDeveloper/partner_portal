package com.partnerportal.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.partnerportal.springboot.entity.ProjectPhase;

public interface ProjectPhaseDao extends JpaRepository<ProjectPhase, Integer>
{
}
