package com.partnerportal.springboot.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RelProjectPhaseBean
{
	private String uuid;
	private int projectId;
	private String title;
	private String description;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private BigDecimal fundRaised;
	private BigDecimal totalFund;

}
