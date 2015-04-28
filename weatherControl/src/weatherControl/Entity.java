package weatherControl;

import java.util.Scanner;

public class Entity {
	String name;
	
	public void askData(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Name: ");
		name = keyboard.nextLine();
	}
	
	public String toString(){
		return "Name: " + name;
	}

	public String showChange(float temperature) {
		// TODO Auto-generated method stub
		return null;
	}
}
