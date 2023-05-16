package com.partnerportal.springboot.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "view_rel_project_user")
@Data
@NoArgsConstructor
public class ViewRelProjectUser
{
	@Id
	@Column(name = "uuid")
	private UUID uuid;

	@Column(name = "id_project")
	private int idProject;

	@Column(name = "id_user")
	private int idUser;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;
}
