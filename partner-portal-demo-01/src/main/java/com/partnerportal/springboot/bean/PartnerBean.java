package com.partnerportal.springboot.bean;

public class PartnerBean
{

	private Integer idPartner;
	private String codePartner;
	private String descPartner;
	private String mail;
	private String phone;
	private String timeCreated;
	private Integer createdBy;
	private String webSite;
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
