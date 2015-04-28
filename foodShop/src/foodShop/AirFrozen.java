package foodShop;

import java.util.Scanner;

public class AirFrozen extends FrozenFood{
	float nitrogenPorcentage;
	float oxigenPorcentage;
	float carbonDioxidePorcentage;
	float waterPorcentage;
	
	public AirFrozen(){
		
	}
	
	public String toString(){
		return super.toString()+ "\nNitrogen %: " +nitrogenPorcentage+ "\nCarbon Dioxide %: " +carbonDioxidePorcentage+ "\nWater %: " +waterPorcentage;

	}
	
	public void askData(){
		Scanner keyboard = new Scanner(System.in);
		
		super.askFrozenFoodData();
		
		System.out.println("Introduce the next elemments porcentage:");
		System.out.print("Nitrogen: ");
		nitrogenPorcentage = keyboard.nextInt(); keyboard.nextLine();
		System.out.print("Oxigen: ");
		oxigenPorcentage = keyboard.nextInt(); keyboard.nextLine();
		System.out.print("C02: ");
		carbonDioxidePorcentage = keyboard.nextInt(); keyboard.nextLine();
		System.out.print("H20: ");
		waterPorcentage = keyboard.nextInt(); keyboard.nextLine();
	
		System.out.println("");
	}
}
