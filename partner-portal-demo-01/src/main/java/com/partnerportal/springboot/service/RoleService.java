package com.partnerportal.springboot.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partnerportal.springboot.dao.RoleRepository;
import com.partnerportal.springboot.entity.Role;

@Service
public class RoleService
{

	private RoleRepository roleRepository;

	@Autowired
	public RoleService(RoleRepository roleRepository)
	{
		this.roleRepository = roleRepository;
	}

	public Collection<Role> findRolesByRoleIds(List<Integer> roleIds)
	{
		return roleRepository.findByRoleIds(roleIds);
	}
}
