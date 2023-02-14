package com.partnerportal.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.partnerportal.springboot.entity.Project;

public interface ProjectDao extends JpaRepository<Project, Integer>
{
	public Project findByTitle(String title);
}
