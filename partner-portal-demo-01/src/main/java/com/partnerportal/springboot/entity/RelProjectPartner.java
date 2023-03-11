package com.partnerportal.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rel_project_partner")
public class RelProjectPartner
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRelProjectPartner")
	private int idRelProjectPartner;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProject", nullable = false)
	private Project project;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPartner", referencedColumnName = "idPartner", nullable = false)
	private Partner partner;

	public int getIdRelProjectPartner()
	{
		return idRelProjectPartner;
	}

	public void setIdRelProjectPartner(int idRelProjectPartner)
	{
		this.idRelProjectPartner = idRelProjectPartner;
	}

	public Project getProject()
	{
		return project;
	}

	public void setProject(Project project)
	{
		this.project = project;
	}

	public Partner getPartner()
	{
		return partner;
	}

	public void setPartner(Partner partner)
	{
		this.partner = partner;
	}

}