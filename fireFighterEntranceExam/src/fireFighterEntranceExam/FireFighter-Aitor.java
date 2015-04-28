package fireFighterEntranceExam;

import java.util.Scanner;

public class FireFighter {
	int resistance = 0;
	int puntuation = 0;

	public void introduceData() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Resistance: ");
		resistance = keyboard.nextInt(); keyboard.nextLine();
		
	}
	public String toString(){
		return	"\nResistance: " + resistance;
	}
}
