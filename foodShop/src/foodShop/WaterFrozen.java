package foodShop;

import java.util.Scanner;

public class WaterFrozen extends FrozenFood{
	float waterSalinity;
	
	public WaterFrozen(){
		
	}

	
	public String toString(){
		return super.toString()+ "\nWater Salinity: " +waterSalinity+ "gr/L";
	}
	
	public void askData(){
		Scanner keyboard = new Scanner(System.in);
		
		super.askFrozenFoodData();
		
		System.out.print("Water Salinity (gr/L): ");
		waterSalinity = keyboard.nextInt(); keyboard.nextLine();
		
		System.out.println("");
	}
}
