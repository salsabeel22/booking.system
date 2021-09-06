package com.booking.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity(name="foods")
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	private String name;
	
	@ManyToMany
	 @JoinTable(
	   name = " pivot_customer_food", 
	   joinColumns = @JoinColumn(name = "food_id"), 
	   inverseJoinColumns = @JoinColumn(name = "customer_id"))
	@JsonIgnore
	 private List < Customer> customer;
	 
	
public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

private int price;
private String abstracts;
	
public Food(Integer id, String name, int price, String abstracts) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.abstracts = abstracts;
	}
public Food() {

}

}
