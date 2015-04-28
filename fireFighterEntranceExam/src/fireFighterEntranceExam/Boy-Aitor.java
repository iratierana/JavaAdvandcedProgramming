package fireFighterEntranceExam;

import java.util.Scanner;

public class Boy extends FireFighter{
	int power = 0;
	
	public void introduceData(){
		Scanner keyboard = new Scanner(System.in);
		super.introduceData();
		System.out.println("Chest Power: ");
		power = keyboard.nextInt(); keyboard.nextLine();
		super.puntuation = (super.resistance +power )/2;
	}	
	
	public String toString(){
		return "Genere: Male" +
				super.toString() +
				"\nPower: " + power + 
				"\nPuntuation: " + super.puntuation +
				"\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-";
	}
	
	
}
