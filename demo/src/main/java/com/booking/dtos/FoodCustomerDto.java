package com.booking.dtos;

public class FoodCustomerDto {
	private Integer FoodId;

	public FoodCustomerDto(Integer foodId) {
		super();
		FoodId = foodId;
	}

	public Integer getFoodId() {
		return FoodId;
	}

	public void setFoodId(Integer foodId) {
		FoodId = foodId;
	}

	public FoodCustomerDto() {

		
	}

}
