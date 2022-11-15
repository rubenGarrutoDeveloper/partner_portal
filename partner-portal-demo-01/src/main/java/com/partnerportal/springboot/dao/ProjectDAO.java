package com.partnerportal.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.partnerportal.springboot.entity.Project;

public interface ProjectDAO extends CrudRepository<Project, Integer>{

}
