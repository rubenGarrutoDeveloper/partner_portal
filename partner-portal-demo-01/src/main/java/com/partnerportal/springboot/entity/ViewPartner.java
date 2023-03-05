package com.partnerportal.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "view_partner")
public class ViewPartner
{

	@Id
	@Column(name = "idPartner")
	private Integer idPartner;

	@Column(name = "codePartner")
	private String codePartner;

	@Column(name = "descPartner")
	private String descPartner;

	@Column(name = "mail")
	private String mail;

	@Column(name = "phone")
	private String phone;

	@Column(name = "timeCreated")
	private String timeCreated;

	@Column(name = "createdBy")
	private Integer createdBy;

	@Column(name = "webSite")
	private String webSite;

	@Column(name = "idProject")
	private Integer idProject;

	public Integer getIdPartner()
	{
		return idPartner;
	}

	public void setIdPartner(Integer idPartner)
	{
		this.idPartner = idPartner;
	}

	public String getCodePartner()
	{
		return codePartner;
	}

	public void setCodePartner(String codePartner)
	{
		this.codePartner = codePartner;
	}

	public String getDescPartner()
	{
		return descPartner;
	}

	public void setDescPartner(String descPartner)
	{
		this.descPartner = descPartner;
	}

	public String getMail()
	{
		return mail;
	}

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getTimeCreated()
	{
		return timeCreated;
	}

	public void setTimeCreated(String timeCreated)
	{
		this.timeCreated = timeCreated;
	}

	public Integer getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy)
	{
		this.createdBy = createdBy;
	}

	public String getWebSite()
	{
		return webSite;
	}

	public void setWebSite(String webSite)
	{
		this.webSite = webSite;
	}

	public Integer getIdProject()
	{
		return idProject;
	}

	public void setIdProject(Integer idProject)
	{
		this.idProject = idProject;
	}
}
