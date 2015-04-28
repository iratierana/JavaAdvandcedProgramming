package weatherControl;

import java.util.Scanner;

public class Main {

	ControlPoint controlPoint;
	
	public static void main(String[] args) {
		Main program = new Main();
		program.menu();

	}

	private void menu() {
		Scanner keyboard = new Scanner(System.in);
		int option = 0;
		
		do{
			System.out.println("***Weather & Forecast Control Program***");
			System.out.println("1. Introduce Control Point");
			System.out.println("2. Define Control Point - Entities links");
			System.out.println("3. Change Control Point temperature");
			System.out.println("0. Exit");
			option = keyboard.nextInt(); keyboard.nextLine();
			
			switch(option){
			case 1: 
				if(controlPoint == null){
				controlPoint = new ControlPoint();
				controlPoint.askData();
				}
				else{
					System.out.println("A control point is already created");
				}
				break;
			case 2: 
				if(controlPoint != null){
					controlPoint.addEntity();
				}
				else{
					System.out.println("You have to create a Control Point previously");
				}
				break;
			case 3: 
				if(controlPoint != null){
					controlPoint.changeTemperature();
				}
				else{
					System.out.println("You have to create a Control Point previously");
				}
			}
			
			
			
		}while(option!=0);
		
	}	
}
