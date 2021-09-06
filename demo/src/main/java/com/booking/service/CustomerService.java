package com.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Food;
import com.booking.models.Reservation;
import com.booking.repositories.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
private CustomerRepo customerepo;
	@Autowired
	private EmployeeService employeeservice;
	@Autowired
	private FoodService foodservice;
	@Autowired
	private ReservationService reservationservice;
	
	public Customer getCustomerById(Integer id ) 
	{ Optional<Customer> customerOptional=customerepo.findById(id);// save  ob that return by find id in varible customeroptional( can have ob or not because optional)
	if(customerOptional.isPresent()) {
return customerOptional.get() ;}
	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found");// return 404 auto if not obj have url id 
	}
	public List <Customer> getCustomerbyEmployeeId( Integer id){	
	return	customerepo.findByEmployeeId(id);
}
	 
	 public Customer creatCustomerforEmployee( Customer customer, Integer id){	
				Employee employee=employeeservice.getEmployeeById(id);
		 customer.setEmployee(employee);
		return customerepo.save(customer);
	 }
	public List<Customer> getAllCustomer( ) {
		 List<Customer> customerOptional=customerepo.findAll();
		return customerOptional;
		
	}
	public Customer creatCustomer(Customer  customer) {
		customerepo.save(customer);//save new obj in db (new obj in class customer)
	return customer ;}
	public Customer updateCustomer(Integer id, Customer reqcustomer) {
		 Optional<Customer> customerOptional=customerepo.findById(id);// save  ob that return by find id in varible customerOptional( can have ob or not because optional)
			if(customerOptional.isPresent()) {
		Customer customerobj= customerOptional.get() ;
		customerobj.setName(reqcustomer.getName());// id can't change in db 
		customerobj.setNumberid(reqcustomer.getNumberid());
		customerepo.save(customerobj);//save new obj in db (new obj in class employee)
		return customerobj ;
		}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found")	;// return 404(not found) auto from spring if not obj have url id 
			}
	
	public Customer addFoodToCustomer(Integer CustomerId ,Integer foodId	) {
		 Optional<Customer> customerOptional=customerepo.findById(CustomerId);// save  ob that return by find id in varible customerOptional( can have ob or not because optional)
			if(customerOptional.isPresent()) {
		Customer customer= customerOptional.get() ;
		Food food=  foodservice.getFoodById( foodId);
		customer.addFood(food);
		 return customerepo.save(customer);
	}
			else
{ throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found")	;// return 404(not found) auto from spring if not obj have url id 
			}	}
	public Customer deleteFoodFromCustomer(Integer foodId ,Integer CustomerId  	) {
		 Optional<Customer> customerOptional=customerepo.findById(CustomerId);// save  ob that return by find id in varible customerOptional( can have ob or not because optional)
			if(customerOptional.isPresent()) {
		Customer customer= customerOptional.get() ;
		Food food=  foodservice.getFoodById( foodId);
		customer.removeFood(food);
		 return customerepo.save(customer);
	}
			else
{ throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found")	;// return 404(not found) auto from spring if not obj have url id 
			}	}
	
	
	
	public void deletCustomer(Integer id) {// no body return by delete
		Optional<Customer> entity= customerepo.findById(id);
			
	if(		entity.isPresent()) {
		customerepo.deleteById(id);	}
	else { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found")	;// return 404(not found) auto from spring if not obj have url id 
}}
	
	
	
	public Customer deleteReservationFromCustomer(Integer reservationid, Integer customerid) {
		
		 Optional<Customer> customerOptional=customerepo.findById(customerid);// save  ob that return by find id in varible customerOptional( can have ob or not because optional)
			if(customerOptional.isPresent()) {
		Customer customer= customerOptional.get() ;
		Reservation reservation=  reservationservice.getReservationById( reservationid);
		customer.removeReservation(reservation);
		 return customerepo.save(customer);
	}
			else { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found")	;// return 404(not found) auto from spring if not obj have url id 
			}}
	}


	
	
	
	
	
	
	
	
	
