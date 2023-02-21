package com.partnerportal.springboot.bean;

import java.util.Date;

public class ProjectBean
{
	private int idProject;
	private String title;
	private String descProject;
	private int idStatus;
	private Date dateLastState;

	public Date getDateLastState()
	{
		return dateLastState;
	}

	public void setDateLastState(Date dateLastState)
	{
		this.dateLastState = dateLastState;
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

	public int getIdStatus()
	{
		return idStatus;
	}

	public void setIdStatus(int idStatus)
	{
		this.idStatus = idStatus;
	}
}
