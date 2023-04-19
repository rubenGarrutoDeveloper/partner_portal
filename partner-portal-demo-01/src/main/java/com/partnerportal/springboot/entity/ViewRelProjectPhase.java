package com.partnerportal.springboot.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "view_rel_project_phase")
@Data
@NoArgsConstructor
public class ViewRelProjectPhase
{
	@Id
	@Column(name = "uuid")
	private String uuid;

	@Column(name = "idProject")
	private int idProject;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "start_time")
	private LocalDateTime startTime;

	@Column(name = "end_time")
	private LocalDateTime endTime;

	@Column(name = "fund_raised")
	private BigDecimal fundRaised;

	@Column(name = "total_fund")
	private BigDecimal totalFund;

}
