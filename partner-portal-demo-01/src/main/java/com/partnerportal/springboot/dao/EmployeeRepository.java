package com.partnerportal.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.partnerportal.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	// method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();

	// search by name
	public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);

}
