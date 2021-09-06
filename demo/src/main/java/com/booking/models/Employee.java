package com.booking.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
	
	@Entity(name="employees")
public class Employee {

	


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id; 
		private String name; 
		private int age; 
		private int salary;
		@OneToMany(mappedBy="employee",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
		@JsonIgnore // back employee only from getEmployee by id wihout customer that link with employee in relation
		private List<Customer> customers;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}

		public Employee(Integer id, String name, int age, int salary) {

			this.id = id;
			this.name = name;
			this.age = age;
			this.salary = salary;
		}
		public Employee() {
			
		}
	
		 public List<Customer> getCustomers(){ 
			 return customers;
}
	
	}


