package com.partnerportal.springboot.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.partnerportal.springboot.bean.UserBean;
import com.partnerportal.springboot.entity.User;
import com.partnerportal.springboot.user.CrmUser;

public interface UserService extends UserDetailsService
{

	public User findByUserName(String userName);

	public Integer save(CrmUser crmUser);

	public List<UserBean> findUsersAssociatedToProject(int idProject);

	public void updateUser(User user);

	public void assignRoleToUser(Integer idUser, Integer idRole);
}
