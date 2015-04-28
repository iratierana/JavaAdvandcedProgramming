package fireFighterEntranceExam;

import java.util.Scanner;

public class Boy extends FireFighter{
	int power = 0;
	
	public void askData(){
		Scanner keyboard = new Scanner(System.in);
		super.askData();
		System.out.println("Chest Power: ");
		power = keyboard.nextInt(); keyboard.nextLine();
	}	
}
