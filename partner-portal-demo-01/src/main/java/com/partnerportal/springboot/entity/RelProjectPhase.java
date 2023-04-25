package com.partnerportal.springboot.entity;

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
@Table(name = "rel_project_phase")
public class RelProjectPhase
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "id_project")
	private int idProject;

	@Column(name = "id_phase")
	private int idPhase;

	// Costruttore con i campi obbligatori
	public RelProjectPhase(int idProject, int idPhase)
	{
		this.idProject = idProject;
		this.idPhase = idPhase;
	}
}
