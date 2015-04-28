package foodShop;

import java.util.Scanner;

public class NitrogenFrozen extends FrozenFood{
	int frozenMethod;
	int frozenSeconds;
	
	public NitrogenFrozen(){
		
	}

	
	public String toString(){
		return super.toString()+ "\nFrozen Method: " +frozenMethod+ "\nFrozen time: " +frozenSeconds+ "seconds";
	}
	
	public void askData(){
		Scanner keyboard = new Scanner(System.in);
		
		super.askFrozenFoodData();
		
		System.out.print("Frozen Method): ");
		frozenMethod = keyboard.nextInt(); keyboard.nextLine();
		System.out.print("Frozen time (seconds): ");
		frozenSeconds = keyboard.nextInt(); keyboard.nextLine();
		System.out.println("");
		
	}
}
