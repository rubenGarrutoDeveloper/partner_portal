package com.partnerportal.springboot.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "project_phase")
public class ProjectPhase
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

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

	// Costruttore con i campi obbligatori
	public ProjectPhase(String title, LocalDateTime startTime, LocalDateTime endTime)
	{
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
