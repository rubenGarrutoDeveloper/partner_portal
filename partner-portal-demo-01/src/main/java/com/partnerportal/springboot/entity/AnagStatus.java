package com.partnerportal.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "anag_status")
public class AnagStatus
{
	@Id
	@Column(name = "idStatus")
	private int idStatus;

	@Column(name = "descState")
	private String stateName;

	public int getIdStatus()
	{
		return idStatus;
	}

	public void setIdStatus(int idStatus)
	{
		this.idStatus = idStatus;
	}

	public String getStateName()
	{
		return stateName;
	}

	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}

}
