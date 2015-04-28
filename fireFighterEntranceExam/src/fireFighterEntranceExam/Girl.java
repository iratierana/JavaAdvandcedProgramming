package fireFighterEntranceExam;

import java.util.Scanner;

public class Girl extends FireFighter{
	int chestPower = 0;
	int speed = 0;
	
	public void askData(){
		Scanner keyboard = new Scanner(System.in);
		super.askData();
		System.out.println("Chest Power: ");
		chestPower = keyboard.nextInt(); keyboard.nextLine();
		System.out.println("Speed: ");
		speed = keyboard.nextInt(); keyboard.nextLine();
	}
}
