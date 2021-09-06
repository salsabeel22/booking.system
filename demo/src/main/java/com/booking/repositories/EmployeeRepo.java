package com.booking.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.booking.models.Employee;

	

	

	public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
		 
		
	public	List<Employee> findAll();

}
