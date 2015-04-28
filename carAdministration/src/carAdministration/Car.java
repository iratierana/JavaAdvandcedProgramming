package carAdministration;

import java.util.Scanner;

public class Car {
	String numberPlate;
	long carFrameNumber = 0;
	String owner;
	String city;
	
	public boolean askCarData(){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Number Plate: ");
		numberPlate = keyboard.nextLine();
		System.out.print("Car Frame Number: ");
		carFrameNumber = keyboard.nextInt(); keyboard.nextLine();
		System.out.print("Owner's name: ");
		owner = keyboard.nextLine();
		System.out.print("City: ");
		city = keyboard.nextLine();
		
		return true;
	
	}
	
	public String toString(){
		return "Number Plate: " + numberPlate +
				"\nCar Frame Number: " + carFrameNumber +
				"\nOwner's name: " + owner +
				"\nCity: " + city;
	}
	
}
