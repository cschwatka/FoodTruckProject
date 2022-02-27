package com.skilldistillery.foodtruck;

import java.util.Scanner;
import java.util.Arrays;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// create array of FoodTruck objects
		FoodTruck[] trucks = new FoodTruck[5];

		FoodTruck truck = new FoodTruck();

		for (int i = 0; i < trucks.length; i++) {

			truck.setTruckId();

			System.out.println("Enter a Name for your Truck (quit if done): ");
			truck.setTruckName(sc.nextLine());

			if (!truck.getTruckName().equalsIgnoreCase("quit")) {

				System.out.println("Enter the Food Type for this Truck: ");
				truck.setFoodType(sc.nextLine());

				System.out.println("Enter your rating for this Truck (0.0 - 5.0): ");
				truck.setRating(sc.nextDouble());
				sc.nextLine(); // janky workaround to input issue

				System.out.println(truck.getTruckName() + " saved to object...");
				truck.displayTruck();

				trucks[i] = new FoodTruck(truck.getTruckId(), truck.getTruckName(), truck.getFoodType(),
						truck.getRating());

				System.out.println(truck.getTruckName() + " checking array ...");

				System.out.println(Arrays.deepToString(trucks));

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
						System.out.println(trucks[i].getTruckName());
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
				String topTruckName = trucks[0].getTruckName();
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
