package com.booking.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.booking.models.Food;


	public interface FoodRepo extends CrudRepository<Food,Integer> {
		 
		

		public List<Food> findAll();

		
		



	}



