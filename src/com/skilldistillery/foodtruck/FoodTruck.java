package com.skilldistillery.foodtruck;

public class FoodTruck {
	private int trucksSaved;

	private int truckId;
	private String truckName;
	private String foodType;
	private double rating;



	// Constructors

	public FoodTruck() {

	}

	public FoodTruck(int tId, String tName, String fType, double rating) {
		this.truckId = tId;
		this.truckName = tName;
		this.foodType = fType;
		this.rating = rating;
	}

	// Setters

	public void setTruckId() {
		this.truckId += 1;
	}
	public void setTruckName(String tName) {
		this.truckName = tName;
	}

	public void setFoodType(String fType) {
		this.foodType = fType;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public void displayTruck() {
		String truckData = toString();
		System.out.println(truckData);
	}

	// Getters
	
	

	public String getTruckName() {
		return truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public double getRating() {
		return rating;
	}
	
	public int getTruckId() {
		return truckId;
	}
	
	public String toString() {
		String output = "truck id=" + truckId + ", name=" + truckName + ", food type=" + foodType + ", rating=" + rating;
		return output;
	}

}
