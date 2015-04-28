package foodShop;

import java.util.Scanner;

public class FrozenFood extends Food {

	Date packingDate;
	String originCountry;
	int recommendedTemperature;
	
	public FrozenFood(){
		packingDate = new Date();
	}
	
	
	public String toString(){
		return  super.toString()+ "\nPacking date:" +packingDate+
				"\nOrigin Country: " +originCountry+
				"\nRecommended Temperature: " +recommendedTemperature;
	}
	
	public void askFrozenFoodData(){
		Scanner keyboard = new Scanner(System.in);
		int day = 0, month = 0, year = 0;
		
		super.askFoodData();
		
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
		
		System.out.print("Introduce the origin country: ");
		originCountry = keyboard.nextLine();
		
		System.out.print("Introduce the recommended temperature for the product: ");
		recommendedTemperature = keyboard.nextInt(); keyboard.nextLine();
		
		System.out.println("");
	}

}
