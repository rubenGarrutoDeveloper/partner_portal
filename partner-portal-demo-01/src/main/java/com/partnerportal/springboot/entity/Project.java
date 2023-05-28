package com.partnerportal.springboot.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProject")
	private Integer idProject;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "descProject", nullable = false)
	private String descProject;

	@Column(name = "codeProject", nullable = false, length = 12, unique = true)
	private String codeProject;

	@Column(name = "createdBy", nullable = false)
	private Integer createdBy;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "rel_project_status", joinColumns = @JoinColumn(name = "idProject"), inverseJoinColumns = @JoinColumn(name = "idStatus"))
	private Collection<AnagStatus> projectStatus;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "rel_project_user", joinColumns = @JoinColumn(name = "idProject"), inverseJoinColumns = @JoinColumn(name = "idUser"))
	private Collection<User> partnerList;

	public Project(Integer idProject, String title, String descProject, String codeProject, Integer createdBy)
	{
		super();
		this.idProject = idProject;
		this.title = title;
		this.descProject = descProject;
		this.codeProject = codeProject;
		this.createdBy = createdBy;
	}
}