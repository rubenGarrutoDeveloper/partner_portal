package com.partnerportal.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "anag_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnagStatus
{

	@Id
	@Column(name = "idStatus")
	private Integer idStatus;

	@Column(name = "descState")
	private String stateName;
}
