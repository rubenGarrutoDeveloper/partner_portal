package com.partnerportal.springboot.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RelProjectPhaseBean
{
	private String uuid;
	private int idProject;
	private String title;
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime endTime;
	private BigDecimal fundRaised;
	private BigDecimal totalFund;

	public RelProjectPhaseBean(int idProject)
	{
		super();
		this.idProject = idProject;
		this.startTime = LocalDateTime.now();
		this.endTime = LocalDateTime.now();
		this.fundRaised = new BigDecimal(0);
		this.totalFund = new BigDecimal(0);
	}

}
