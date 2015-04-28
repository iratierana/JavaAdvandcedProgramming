package foodShop;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	ArrayList <Food> foodList = new ArrayList<>();

	public static void main(String[] args) {
		Main general = new Main();
		general.optionsMenu();

	}


	public void optionsMenu() {
		int option = 0;
		Scanner keyboard = new Scanner(System.in);
		//ArrayList<Food> foodList = new ArrayList<Food>();
		
		System.out.println("***Welcome to the Food Shop***");
		
		do{
			System.out.println("Select a option:");
			System.out.println("1. Add food");
			System.out.println("2. See all foods added");
			System.out.println("0. Exit");
			option = keyboard.nextInt(); keyboard.nextLine();
			
			switch(option){
			case 1: addFood();
				break;
			case 2: seeFood();
				break;
			}
			
		}while(option!=0);
	}


	public void addFood() {
		Scanner keyboard = new Scanner(System.in);
		int option = 0;
		
		System.out.println("Select a type of food:");
		System.out.println("1. Fresh Food");
		System.out.println("2. Cool Food");
		System.out.println("3. Frozen Food");
		System.out.println("0. Exit");
		option = keyboard.nextInt(); keyboard.nextLine();
		System.out.println("");
		
		switch (option){
		case 1:
			FreshFood freshFood = new FreshFood();
			freshFood.askFreshFoodData();
			foodList.add(freshFood);
			break;
		case 2:
			CoolFood coolFood = new CoolFood();
			coolFood.askCoolFoodData();
			foodList.add(coolFood);
			break;
		case 3:
			System.out.println("Select a type of freezing system:");
			System.out.println("1. By Air");
			System.out.println("2. By Water");
			System.out.println("3. By Nitrogen");
			System.out.println("0. Exit");
			int frozenOption = keyboard.nextInt(); keyboard.nextLine();
			System.out.println("");
		
			switch (frozenOption){
			case 1:
				AirFrozen airFrozenFood = new AirFrozen();
				airFrozenFood.askData();
				foodList.add(airFrozenFood);
				break;
			case 2:
				WaterFrozen waterFrozenFood = new WaterFrozen();
				waterFrozenFood.askData();
				foodList.add(waterFrozenFood);
				break;
			case 3:
				NitrogenFrozen nitrogenFrozenFood = new NitrogenFrozen();
				nitrogenFrozenFood.askData();
				foodList.add(nitrogenFrozenFood);
				break;
			}
			
			break;
		}
	}
	
	private void seeFood() {
		
		for(Food f : foodList){
			System.out.println(f.toString());
			System.out.println("----------------");
		}
		
	}

}
