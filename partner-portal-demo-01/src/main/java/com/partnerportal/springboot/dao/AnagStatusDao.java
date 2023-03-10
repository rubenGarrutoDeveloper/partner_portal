package com.partnerportal.springboot.dao;

import com.partnerportal.springboot.entity.AnagStatus;

public interface AnagStatusDao
{
	public AnagStatus findStatusByID(int idStatus);
}
