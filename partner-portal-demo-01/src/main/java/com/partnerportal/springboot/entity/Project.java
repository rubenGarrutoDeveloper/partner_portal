package com.partnerportal.springboot.entity;

import java.sql.Clob;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="project")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="projectID")
	private Integer projectID;
	
	@Column(name="prName")
	private String prName;
	
	@Column(name="shortDesc")
	private String shortDesc;
	
	@Column(name="longDesc")
	private Clob longDesc;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="completedStatus")
	private Integer completedStatus;
	
	@Column(name="projectStartDate")
	private Date projectStartDate;
	
	@Column(name="projectEndDate")
	private Date projectEndDate;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	@Column(name="created")
	private Timestamp Created;
	
	@Column(name="updated")
	private Timestamp updated;
	
	@Column(name="pathLogo")
	private String pathLogo;

	
	public Project(Integer projectID, String prName, String shortDesc, Clob longDesc, Integer status,
			Integer completedStatus, Date projectStartDate, Date projectEndDate, String createdBy, String updatedBy,
			Timestamp created, Timestamp updated, String pathLogo) {
		super();
		this.projectID = projectID;
		this.prName = prName;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.status = status;
		this.completedStatus = completedStatus;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		Created = created;
		this.updated = updated;
		this.pathLogo = pathLogo;
	}

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public String getPrName() {
		return prName;
	}

	public void setPrName(String prName) {
		this.prName = prName;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public Clob getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(Clob longDesc) {
		this.longDesc = longDesc;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCompletedStatus() {
		return completedStatus;
	}

	public void setCompletedStatus(Integer completedStatus) {
		this.completedStatus = completedStatus;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getCreated() {
		return Created;
	}

	public void setCreated(Timestamp created) {
		Created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public String getPathLogo() {
		return pathLogo;
	}

	public void setPathLogo(String pathLogo) {
		this.pathLogo = pathLogo;
	}

	
}
