package com.partnerportal.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "view_project")
public class ViewProject
{
	@Id
	@Column(name = "idProject")
	private int idProject;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "descProject", nullable = false)
	private String descProject;

	@Column(name = "idState", nullable = false)
	private int idState;

	public int getIdState()
	{
		return idState;
	}

	public void setIdState(int idState)
	{
		this.idState = idState;
	}

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