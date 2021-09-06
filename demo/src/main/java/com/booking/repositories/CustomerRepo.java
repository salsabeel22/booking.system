package com.booking.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.booking.models.Customer;



public interface CustomerRepo extends CrudRepository<Customer,Integer> {
	 
	
public	List<Customer> findAll();
 public List <Customer> findByEmployeeId(Integer id);
}

