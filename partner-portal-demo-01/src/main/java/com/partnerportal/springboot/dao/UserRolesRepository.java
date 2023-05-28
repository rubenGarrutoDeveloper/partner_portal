package com.partnerportal.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.partnerportal.springboot.entity.UsersRoles;

@Repository
public interface UserRolesRepository extends JpaRepository<UsersRoles, Integer>
{

	// Save the UserRoles entity
	public UsersRoles save(UsersRoles userRoles);

	@Query("SELECT ur.roleId FROM UsersRoles ur WHERE ur.userId = :userId")
	public List<Integer> findUserRolesIds(@Param("userId") Integer userId);
}
