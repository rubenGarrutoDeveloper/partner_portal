package com.partnerportal.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.partnerportal.springboot.entity.Project;
import com.partnerportal.springboot.entity.ViewProject;

public interface ViewProjectDao extends JpaRepository<ViewProject, Integer>
{
	public Project findByTitle(String title);

	List<ViewProject> findAllByOrderByDateLastStateDesc();
}
