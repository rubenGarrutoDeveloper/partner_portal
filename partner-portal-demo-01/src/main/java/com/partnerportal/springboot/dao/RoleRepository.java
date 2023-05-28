package com.partnerportal.springboot.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.partnerportal.springboot.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>
{

	@Query("SELECT r FROM Role r WHERE r.id IN :roleIds")
	public Collection<Role> findByRoleIds(@Param("roleIds") List<Integer> roleIds);
}