package foodShop;

import java.util.Scanner;

public class CoolFood extends Food {
	

	int foodSupervisionOrganization;
	Date packingDate;
	int recommendedTemperature;
	String originCountry;
	
	public CoolFood() {
		packingDate = new Date();
	}
	

	
	public String toString(){
		return  super.toString()+ "\nFood Supervision Organization: " +foodSupervisionOrganization+
				"\nPacking date:" +packingDate+
				"\nRecommended Temperature: " +recommendedTemperature+
				"\nOrigin Country: " +originCountry;
	}
	
	public void askCoolFoodData(){
		Scanner keyboard = new Scanner(System.in);
		int day = 0, month = 0, year = 0;
		
		super.askFoodData();
		
		System.out.print("Introduce the Food Supervision Organization: ");
		foodSupervisionOrganization = keyboard.nextInt(); keyboard.nextLine();
		
		System.out.println("Introduce the Packing Date:");
		System.out.print("Year: ");
		year = keyboard.nextInt(); keyboard.nextLine();
		packingDate.setYear(year);
		System.out.print("Month: ");
		month = keyboard.nextInt(); keyboard.nextLine();
		packingDate.setMonth(month);
		System.out.print("Day: ");
		day = keyboard.nextInt(); keyboard.nextLine();
		packingDate.setDay(day);
		
		System.out.print("Introduce the recommended temperature for the product: ");
		recommendedTemperature = keyboard.nextInt(); keyboard.nextLine();
		
		System.out.print("Introduce the origin country: ");
		originCountry = keyboard.nextLine();
		
		System.out.println("");
	}
}
