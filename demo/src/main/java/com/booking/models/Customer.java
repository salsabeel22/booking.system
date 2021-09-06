package com.booking.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="customers")
public class Customer {

	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id ; 
	private String numberid;
	 private String name;
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="emp_id")
	
	 
	 @JsonIgnore
	 private Employee employee;
	 
		 @OneToMany(mappedBy="customer",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	 
	// @JsonIgnore
		private List<Reservation> reservations;
	
	 public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	@ManyToMany
	 @JoinTable(
	   name = " pivot_customer_food", 
	   joinColumns = @JoinColumn(name = "customer_id"), 
	   inverseJoinColumns = @JoinColumn(name = "food_id"))
	 //@JsonIgnore
	 private List < Food> foods;
	 
	
	
	public List<Food> getFoods() {
		return foods;
	}
	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
	public String getNumberid() {
		return numberid;
	}
	public void setNumberid(String numberid) {
		this.numberid = numberid;
	}
	public Customer(Integer id, String numberid, String name, Employee employee) {

		this.id = id;
		this.numberid = numberid;
		this.name = name;
		this.employee=employee;
	}
	public Customer() {

	}
	 public List<Reservation> getReservations() {
			return reservations;
}
	public void addFood(Food food) {
 this.foods.add(food);
		
	}
	public void removeFood(Food food) {
		
		 this.foods.remove(food);
	}
	
	public void addReservation(Reservation reservation) {
		 this.reservations.add(reservation);
				
			}
	public void removeReservation(Reservation reservation) {
		 this.reservations.remove(reservation);
				
			}

}