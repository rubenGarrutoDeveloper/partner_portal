package com.partnerportal.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.partnerportal.springboot.entity.ViewRelProjectUser;

public interface ViewRelProjectUserDao extends JpaRepository<ViewRelProjectUser, Integer>
{
	@Query("SELECT vp FROM ViewRelProjectUser vp WHERE vp.idProject = :idProject")
	public List<ViewRelProjectUser> findUserAssociatedToProject(@Param("idProject") int idProject);
}
