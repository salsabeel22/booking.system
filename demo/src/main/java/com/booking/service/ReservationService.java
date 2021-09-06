package com.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Reservation;
import com.booking.repositories.ReservationRepo;

@Service
public class ReservationService {
	



	@Autowired
private ReservationRepo reservationrepo ;
	@Autowired
	private CustomerService customerservice;
	
	public Reservation getReservationById(Integer id ) 
	{ Optional <Reservation> reservationOptional=reservationrepo.findById(id);// save  ob that return by find id in varible ( can have ob or not because optional)
	if(reservationOptional.isPresent()) {
return reservationOptional.get() ;}
	throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Reservation not found");// return 404 auto if not obj have url id 
	}
	
	public List <Reservation> getReservationbyCustomerId( Integer id){	
	return	reservationrepo.findByCustomerId(id);
}
	 
	 public Reservation creatReservationforCustomer( Reservation reservation, Integer id){	
				Customer customer=customerservice.getCustomerById(id);
				reservation.setCustomer(customer);
		return reservationrepo.save(reservation);
	 }
	 
	public List<Reservation> getAllReservation( ) {
		 List<Reservation> reservationOptional=reservationrepo.findAll();
		return reservationOptional;
		
	}
	public void deletereservation(Integer id) {// no body return by delete
		Optional<Reservation> entity= reservationrepo.findById(id);
			
	if(		entity.isPresent()) {
		reservationrepo.deleteById (id);	}
	else { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not found")	;// return 404(not found) auto from spring if not obj have url id 
}}

	public Reservation updatereservation(Integer id, Reservation reservationrequest) {

			Optional<Reservation> reservationOptional = reservationrepo.findById(id);
			if (reservationOptional.isPresent()) {
				Reservation reservationObj = reservationOptional.get();
				reservationObj.setRoom_number(reservationrequest.getRoom_number());
				reservationObj.setStart_date(reservationrequest.getStart_date());
				reservationObj.setEnd_date(reservationrequest.getEnd_date());
				reservationrepo.save(reservationObj);
				return reservationObj;
			}
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "Student Not Found");
		}
	public Reservation create(Reservation  reservation) {
		reservationrepo.save(reservation);//save new obj in db (new obj in class customer)
	return reservation ;}
	}


