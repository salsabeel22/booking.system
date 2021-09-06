package com.booking.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.booking.models.Reservation;

	public interface ReservationRepo extends CrudRepository<Reservation,Integer> {
		 
		

	public List<Reservation> findAll();
	public List<Reservation> findByCustomerId(Integer id);



}
