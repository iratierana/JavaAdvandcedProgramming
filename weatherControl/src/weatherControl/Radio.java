package weatherControl;

import java.util.Scanner;

public class Radio extends Entity{
	String city;
	
	public void askData(){
		Scanner keyboard = new Scanner(System.in);
		super.askData();
		System.out.println("City: ");
		city = keyboard.nextLine();
	}
	
	public String toString(){
		return super.toString() +
				"\nCity: " + city +
				"\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-";
	}
	
	public String showChange(float temperature){
		return 	"\nThe radio of " + super.name + " has found a new temperature of " + temperature +
				"\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-";
	}
}
