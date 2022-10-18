package com.partnerportal.springboot.dao;

import com.partnerportal.springboot.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
