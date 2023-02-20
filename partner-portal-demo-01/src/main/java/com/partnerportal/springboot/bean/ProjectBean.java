package com.partnerportal.springboot.bean;

public class ProjectBean
{
	private int idProject;
	private String title;
	private String descProject;
	private int idState;

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

	public int getIdState()
	{
		return idState;
	}

	public void setIdState(int idState)
	{
		this.idState = idState;
	}
}
