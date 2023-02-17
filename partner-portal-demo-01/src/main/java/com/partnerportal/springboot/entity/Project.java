package com.partnerportal.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProject")
	private int idProject;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "descProject", nullable = false)
	private String descProject;

	public int getIdProject()
	{
		return idProject;
	}

	public void setIdProject(int idProject)
	{
		this.idProject = idProject;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescProject()
	{
		return descProject;
	}

	public void setDescProject(String descProject)
	{
		this.descProject = descProject;
	}

}