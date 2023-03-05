package com.partnerportal.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.partnerportal.springboot.entity.ViewPartner;

public interface ViewPartnerDao extends JpaRepository<ViewPartner, Integer>
{
	@Query("SELECT vp FROM ViewPartner vp WHERE vp.idProject = :idProject")
	public List<ViewPartner> findPartnersAssociatedToProject(@Param("idProject") int idProject);
}
