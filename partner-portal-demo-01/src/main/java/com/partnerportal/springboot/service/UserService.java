package com.partnerportal.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.partnerportal.demo.user.CrmUser;
import com.partnerportal.springboot.entity.User;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}
