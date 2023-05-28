package com.partnerportal.springboot.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectBean
{
	private Integer idProject;
	private String title;
	private String descProject;
	private Integer idStatus;
	private Date dateLastState;
	private String codeProject;
	private Integer createdBy;
	private String nameCreatedBy;
}
