package weatherControl;

import java.util.Scanner;

public class MeteorogicalStation extends Entity{
	String ubication;
	
	public void askData(){
		Scanner keyboard = new Scanner(System.in);
		super.askData();
		System.out.println("Ubication: ");
		ubication = keyboard.nextLine();
	}
	
	public String toString(){
		return super.toString() +
				"\nUbication: " + ubication +
				"\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-";
	}
	public String showChange(float temperature){
		return 	"\nThe meteorogical station of " + super.name + " has found a new temperature of " + temperature +
				"\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-";
	}
}
