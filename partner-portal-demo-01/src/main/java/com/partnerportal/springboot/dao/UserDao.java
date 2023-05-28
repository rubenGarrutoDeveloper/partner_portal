package com.partnerportal.springboot.dao;

import com.partnerportal.springboot.entity.User;

public interface UserDao
{

	public User findByUserName(String userName);

	public User getLoggedUser();

	public Integer save(User user);

}
