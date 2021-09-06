package com.booking.models;

import java.sql.Timestamp;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="reservations")
public class Reservation {
@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	private int room_number; 
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Timestamp start_date; 
	private Timestamp end_date;
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="customer_id")
	 @JsonIgnore
	 private Customer customer;
	 @JsonIgnore
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Reservation(Integer id, int room_number, Timestamp start_date, Timestamp end_date,Customer customer) {
	
		this.id = id;
		this.room_number = room_number;
		this.start_date = start_date;
		this.end_date = end_date;
		this.customer=customer ;
		
	}


	public Reservation() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getRoom_number() {
		return room_number;
	}


	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}


	public Timestamp getStart_date() {
		return start_date;
	}


	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}


	public Timestamp getEnd_date() {
		return end_date;
	}


	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}
	
	
	
}
