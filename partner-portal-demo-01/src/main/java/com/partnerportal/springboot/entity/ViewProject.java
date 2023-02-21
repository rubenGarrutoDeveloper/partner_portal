package com.partnerportal.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "idStatus")
	private AnagStatus anagStatus;

	@Column(name = "dateLastState")
	private Date dateLastState;

	public Date getDateLastState()
	{
		return dateLastState;
	}

	public void setDateLastState(Date dateLastState)
	{
		this.dateLastState = dateLastState;
	}

	public int getIdStatus()
	{
		return anagStatus.getIdStatus();
	}

	public void setIdStatus(int idStatus)
	{
		this.anagStatus.setIdStatus(idStatus);
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