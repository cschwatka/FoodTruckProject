package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// create array of FoodTruck objects
		FoodTruck[] trucks = new FoodTruck[5];

		FoodTruck truck = new FoodTruck();
		
		System.out.println("You can enter up to 5 Food Trucks.\nLet's begin...\n");

		for (int i = 0; i < trucks.length; i++) {

			truck.setTruckId(0);

			System.out.println("Please enter a Name for your Truck (quit if done): ");
			truck.setTruckName(sc.nextLine());

			if (!truck.getTruckName().equalsIgnoreCase("quit")) {

				System.out.println("Enter the Food Type for this Truck: ");
				truck.setFoodType(sc.nextLine());
				
				System.out.println("Enter your rating for this Truck (0.0 - 5.0): ");
				truck.setRating(sc.nextDouble());
				sc.nextLine(); // janky workaround to input issue

				System.out.println(truck.getTruckName() + " saving...");
				truck.displayTruck();

				trucks[i] = new FoodTruck(truck.getTruckId(), truck.getTruckName(), truck.getFoodType(),
						truck.getRating());

				System.out.println(truck.getTruckName() + " saved.\n");


			}

			else {
				System.out.println("Quitting input...");
				break;
			}

		}

		// Menu
		int selection;
		while (true) {
			System.out.println(
					"Please choose from the menu:\n1:\tList all existing food trucks.\n2:\tSee the average rating of food trucks.\n3:\tDisplay the highest-rated food truck.\n4:\tQuit the program.");

			selection = sc.nextInt();

			switch (selection) {

			case 1:
				for (int i = 0; i < trucks.length; i++) {
					if (trucks[i] != null) {
//						System.out.println(trucks[i].getTruckName());
						trucks[i].displayTruck();
					} else {
						continue;
					}
				}
				break;

			case 2:
				double sumRatings = 0.0;
				double averageRatings = 0.0;
				for (int i = 0; i < trucks.length; i++) {
					if (trucks[i] != null) {
//						System.out.println(trucks[i].getRating());
						sumRatings += trucks[i].getRating();
						averageRatings = sumRatings / trucks[i].getTruckId(); // a little lazy, but should work since my id will match count ... test this though
					} 
					
					else {
						continue;
					}
					
				}
				
//				System.out.println(sumRatings);
				System.out.println("The average rating of all trucks is:" + averageRatings);
				break;
			case 3:
				FoodTruck topTruck = new FoodTruck();
//				String topTruckName = trucks[0].getTruckName();
				double best = 0.0;
				
				for (int i = 0; i < trucks.length; i++) {
					
					if (trucks[i] != null && trucks[i].getRating() > best ) {
						best = trucks[i].getRating();
						topTruck = trucks[i];
					}
					
					
				}
				
				System.out.println("The highest-rated food truck has a rating of: " + best );
				System.out.println("Here are its details: " + topTruck.toString() );
				break;
			case 4:
				System.out.println("Exiting program...");
				return;
			default:
				System.out.println("Not a valid Menu option. Try again.");
			}
		}

	}
}
