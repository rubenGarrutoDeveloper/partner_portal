package com.partnerportal.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.partnerportal.springboot.entity.User;
import com.partnerportal.springboot.user.CrmUser;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}
