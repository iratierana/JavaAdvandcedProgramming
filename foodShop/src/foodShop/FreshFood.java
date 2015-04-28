package foodShop;

import java.util.Scanner;

public class FreshFood extends Food{
	Date packingDate;
	String originCountry;
	
	public FreshFood(){
		packingDate = new Date();
	}
	
	
	public String toString(){
		return super.toString()+"\nPacking date:" +packingDate+ "\nOrigin Country: " +originCountry;
	}
	
	public void askFreshFoodData(){
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
		
		System.out.println("");
	}
}
