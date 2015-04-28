package weatherControl;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class ControlPoint {
	String ubication;
	float temperature = 0;
	
	ArrayList<Entity> entityList;
	ListIterator<Entity> entityListIt;
	
	public ControlPoint(){
		entityList = new ArrayList<Entity>();
		
	}

	public void askData(){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Introduce the ubication of the Control Point: ");
		ubication = keyboard.nextLine();
		System.out.print("Introduce the Temperature: ");
		temperature = keyboard.nextFloat(); keyboard.nextLine();
		
	}
	
	public void addEntity(){
		int option;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Select a type of Entity:");
		System.out.println("1. Television");
		System.out.println("2. Meteorogical Station");
		System.out.println("3. Radio Station");
		option = keyboard.nextInt(); keyboard.nextLine();
		
		switch(option){
		case 1:
			Television television = new Television();
			television.askData();
			entityList.add(television);
			break;
		case 2:
			MeteorogicalStation meteorogicalStation = new MeteorogicalStation();
			meteorogicalStation.askData();
			entityList.add(meteorogicalStation);
			break;
		case 3:
			Radio radio = new Radio();
			radio.askData();
			entityList.add(radio);
			break;
		}
	}
	
	public void changeTemperature(){
		entityListIt = entityList.listIterator();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Introduce the new temperature: ");
		temperature = keyboard.nextFloat(); keyboard.nextLine();
		
		while(entityListIt.hasNext()){
			System.out.println((entityListIt.next()).showChange(temperature));
		}
		
		
		
	}
	
	public String toString(){
		return	"Ubication: " + ubication +
				"\nTemperature: " + temperature;
	}
}
