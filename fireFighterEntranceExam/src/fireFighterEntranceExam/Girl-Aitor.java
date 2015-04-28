package fireFighterEntranceExam;

import java.util.Scanner;

public class Girl extends FireFighter{
	int chestPower = 0;
	int speed = 0;
	
	public void introduceData(){
		Scanner keyboard = new Scanner(System.in);
		super.introduceData();
		System.out.println("Chest Power: ");
		chestPower = keyboard.nextInt(); keyboard.nextLine();
		System.out.println("Speed: ");
		speed = keyboard.nextInt(); keyboard.nextLine();
		super.puntuation = (super.resistance + (chestPower + speed)/2)/2;
	}
	
	public String toString(){
		return "Genere: Female" +
				super.toString() +
				"\nChest Power: " + chestPower +
				"\nSpeed: " + speed + 
				"\nPuntuation: " + super.puntuation +
				"\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-";
	}
}
