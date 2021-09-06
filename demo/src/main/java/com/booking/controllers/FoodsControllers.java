package com.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Food;

import com.booking.service.FoodService;

@RestController

public class FoodsControllers {

	@Autowired
	private  FoodService foodservice ;
	
	@GetMapping(value="/foods")
	public List<Food> getFood() {	
			
		return foodservice.getAllFood();}

	
	@GetMapping(value="/foods/{id}")
	public Food getFood(@PathVariable Integer id){	
			return foodservice.getFoodById(id);
					}
	
	@PostMapping(value="/food")
	public Food creatFood(@RequestBody Food food){	
		
		foodservice.creatFood(food);
		return food ;}

}
