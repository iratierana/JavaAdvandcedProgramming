package fireFighterEntranceExam;

import java.util.Scanner;

public class FireFighter {
	int resistance = 0;

	public void askData() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Chest Power: ");
		resistance = keyboard.nextInt(); keyboard.nextLine();
		
	}
}
