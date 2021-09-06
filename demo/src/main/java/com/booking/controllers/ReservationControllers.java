package com.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.models.Reservation;
import com.booking.service.ReservationService;
@RestController
public class ReservationControllers {
	
	
	
	
	@Autowired
	private  ReservationService reservationservice ;
	

				@GetMapping(value="/reservations/{id}")
			public Reservation getReservationById(@PathVariable Integer id){	
					return reservationservice.getReservationById(id);
							}

				@GetMapping(value="/customers/{id}/reservations")
			public List <Reservation> getReservationbyCustomerId(@PathVariable Integer id){	
					return reservationservice.getReservationbyCustomerId(id);
							}
				
	@GetMapping(value="/reservations")
				public List<Reservation> getReservation() {	
						
					return reservationservice.getAllReservation();}
					@PostMapping(value="/customers/{id}/reservations")
								public Reservation creatReservationforCustomer (@PathVariable Integer id,@RequestBody Reservation reservation) {
					return	reservationservice.creatReservationforCustomer(reservation,id);//save new obj in db (new obj in class Reservation)
						 }
	
	
	

}
