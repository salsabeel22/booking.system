package com.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.models.Employee;
import com.booking.service.EmployeeService;




@RestController
public class EmployeeControllers {
	@Autowired
	 EmployeeService employeeservice;
		
			@GetMapping(value="/employees/{id}")
		public Employee getEmployee(@PathVariable Integer id){	
				return employeeservice.getEmployeeById(id);
						}

		/*	@GetMapping(value="/employees/{id}/customers")
		
				return customerservice.getCustomerByEmployeeId(id);
						}*/
			@GetMapping(value="/employees")
			public List<Employee> getEmployee() {	
					
				return employeeservice.getAllEmployee();}
				@PostMapping(value="/employees")
					public Employee creatEmployee(@RequestBody Employee employee){	
							
					employeeservice.creatEmployee(employee);//save new obj in db (new obj in class employee)
					return employee ;}

						
							@PutMapping(value="/employees/{id}") // determine what obj or what entity  i want update it by id because is unique ...
								public Employee updateEmployee(@PathVariable Integer id,@RequestBody Employee reqemployee) {
								return employeeservice.updateEmployee(id, reqemployee );
							}
										@DeleteMapping(value="/employees/{id}")
											public void deletEmployee(@PathVariable Integer id) {// no body return by delete
											employeeservice .deletEmployee(id);
	}}

