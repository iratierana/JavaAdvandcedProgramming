package weatherControl;

import java.util.Scanner;

public class Television extends Entity{
	String comunity;
	
	public void askData(){
		Scanner keyboard = new Scanner(System.in);
		super.askData();
		System.out.println("Comunity: ");
		comunity = keyboard.nextLine();
	}
	
	public String toString(){
		return super.toString() +
				"\nComunity: " + comunity +
				"\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-";
	}
	
	public String showChange(float temperature){
		return 	"\nThe television of " + super.name + "has found a new temperature of " + temperature +
				"\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-";
	}
}
