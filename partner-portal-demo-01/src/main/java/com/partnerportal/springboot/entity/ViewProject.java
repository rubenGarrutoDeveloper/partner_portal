package com.partnerportal.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "view_project")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewProject
{
	@Id
	@Column(name = "idProject")
	private Integer idProject;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "descProject", nullable = false)
	private String descProject;

	@Column(name = "codeProject")
	private String codeProject;

	@Column(name = "createdBy")
	private Integer createdBy;

	@Column(name = "nameCreatedBy")
	private String nameCreatedBy;

	@ManyToOne
	@JoinColumn(name = "idStatus")
	private AnagStatus anagStatus;

	@Column(name = "dateLastState")
	private Date dateLastState;
}