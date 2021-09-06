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
import com.booking.repositories.FoodRepo;
@Service
public class FoodService {

	
	@Autowired
	private FoodRepo foodrepo ;
	 
		public List<Food> getAllFood( ) {
			 List<Food> foodOptional=foodrepo.findAll();
			return foodOptional;
			
		}

		public Food getFoodById(Integer id ) 
		{ Optional<Food> foodOptional=foodrepo.findById(id);
		if(foodOptional.isPresent()) {
	return foodOptional.get() ;}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found");// return 404 auto if not obj have url id 
		}
		public void deletFood(Integer id) {// no body return by delete
			Optional<Food> entity= foodrepo.findById(id);
				
		if(		entity.isPresent()) {
			foodrepo.deleteById(id);	}
		else { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found")	;// return 404(not found) auto from spring if not obj have url id 
	}}
		public Food creatFood(Food food) {
			foodrepo.save(food);//save new obj in db (new obj in class employee)
		return food ;}

		public Food updatefood(Integer id, Food foodrequest) {
			
			Optional<Food> foodOptional = foodrepo.findById(id);
			if (foodOptional.isPresent()) {
				Food foodObj = foodOptional.get();
				foodObj.setName(foodrequest.getName());
				foodObj.setPrice(foodrequest.getPrice());
				foodObj.setAbstracts(foodrequest.getAbstracts());
				foodrepo.save(foodObj);
				return foodObj;
			}
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "Student Not Found");
		}
		}

