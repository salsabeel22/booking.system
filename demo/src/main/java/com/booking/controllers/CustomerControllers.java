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

import com.booking.dtos.FoodCustomerDto;
import com.booking.models.Customer;
import com.booking.service.CustomerService;

@RestController
	public class CustomerControllers {
		@Autowired
		CustomerService customerservice;
			
				@GetMapping(value="/customers/{id}")
			public Customer getCustomer(@PathVariable Integer id){	
					return customerservice.getCustomerById(id);
							}

				@GetMapping(value="/employees/{id}/customers")
			public List <Customer> getCustomerbyEmployeeId(@PathVariable Integer id){	
					return customerservice.getCustomerbyEmployeeId(id);
							}
				
		@GetMapping(value="/customers")
				public List<Customer> getCustomer() {	
						
					return customerservice.getAllCustomer();}
		
		
					@PostMapping(value="/employees/{id}/customers")
								public Customer creatCustomerforEmployee (@PathVariable Integer id,@RequestBody Customer customer) {
					return	customerservice.creatCustomerforEmployee(customer,id);//save new obj in db (new obj in class customer)
						 }

					@PostMapping(value="/customers/{id}") // determine what obj or what entity  i want update it by id because is unique ...
					public Customer creatCustomer(@RequestBody Customer reqcustomer) {
						return customerservice.creatCustomer( reqcustomer );}
							
								/*@PutMapping(value="/customers/{id}") // determine what obj or what entity  i want update it by id because is unique ...
								public Customer updateCustomer(@PathVariable Integer id,@RequestBody Customer reqcustomer) {
									return customerservice.updateCustomer(id, reqcustomer );
								}*/
											@DeleteMapping(value="/customers/{id}")
												public void deletEmployee(@PathVariable Integer id) {// no body return by delete
												customerservice .deletCustomer(id);
											}
											
												@PutMapping(value="/customers/{id}") // determine what obj or what entity  i want update it by id because is unique ...
												public Customer addFoodToCustomer(@PathVariable Integer id,@RequestBody FoodCustomerDto foodId) {
													return customerservice.addFoodToCustomer(id, foodId.getFoodId() );
												}		
											
												@DeleteMapping(value="/customers/{customerid}/{foodId}") // determine what obj or what entity  i want update it by id because is unique ...
												public void deleteFoodFromCustomer(@PathVariable Integer customerid, @PathVariable Integer foodId) {
													 customerservice.deleteFoodFromCustomer(customerid, foodId);
												}		
											
												
											}


	
	


