package com.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.models.Employee;
import com.booking.repositories.EmployeeRepo;

@Service

public class EmployeeService {

	@Autowired
	private EmployeeRepo employeerepo;
		
		public Employee getEmployeeById(Integer id ) 
		{ Optional<Employee> employeeOptional=employeerepo.findById(id);// save  ob that return by find id in varible employeeoptional( can have ob or not because optional)
		if(employeeOptional.isPresent()) {
	return employeeOptional.get() ;}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not found")	;// return 404 auto if not obj have url id 
			
			
			
	}
		
		public List<Employee> getAllEmployee( ) {
			 List<Employee> employeeOptional=employeerepo.findAll();
			return employeeOptional;
			
		}
		public Employee creatEmployee(Employee employee) {
			employeerepo.save(employee);//save new obj in db (new obj in class employee)
		return employee ;}
		public Employee updateEmployee(Integer id, Employee reqemployee) {
			 Optional<Employee> employeeOptional=employeerepo.findById(id);// save  ob that return by find id in varible employeeOptional( can have ob or not because optional)
				if(employeeOptional.isPresent()) {
			Employee employeeobj= employeeOptional.get() ;
			employeeobj.setName(reqemployee.getName());// id can't change in db 
			employeeobj.setAge(reqemployee.getAge());
			
			employeeobj.setSalary(reqemployee.getSalary());
			
			
			employeerepo.save(employeeobj);//save new obj in db (new obj in class employee)
			return employeeobj ;
			}
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not found")	;// return 404(not found) auto from spring if not obj have url id 
				}
		public void deletEmployee(Integer id) {// no body return by delete
			Optional<Employee> entity= employeerepo.findById(id);
				
		if(		entity.isPresent()) {
			employeerepo.deleteById (id);	}
		else { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not found")	;// return 404(not found) auto from spring if not obj have url id 
	}}}
		
		

	
	
	

