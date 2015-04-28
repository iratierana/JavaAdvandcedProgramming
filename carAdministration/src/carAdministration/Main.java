package carAdministration;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	ArrayList<Car> carList;
	ListIterator<Car> carListIt;
	
	public static void main(String[] args) {
		Main program = new Main();
		program.menu();

	}

	private void menu() {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		int option = 0;
		carList = new ArrayList<Car>();
		
		do{
			System.out.println("***Car administration program***");
			System.out.println("1. Introduce car");
			System.out.println("2. See all cars");
			System.out.println("0. Exit");
			option = keyboard.nextInt(); keyboard.nextLine();
			
			switch(option){
			case 1: addCar();
				break;
			case 2: seeCarList();
				break;
			}
			
			
		}while(option!=0);
		
	}
	
	private boolean addCar() {
		Car car = null;
		car = new Car();
		boolean valid = true;
		
		if(car.askCarData()){
			carListIt = carList.listIterator();
			while(carListIt.hasNext()){
				if(car.carFrameNumber == carListIt.next().carFrameNumber){
					System.out.println("The Car Frame Number introduced is not valid");
					valid = false;
					break;
				}
			}
		}
		else{
			System.out.println("E");
			valid = false;
		}
		if(valid){
			carList.add(car);
			return true;
		}
		return false;
		
	}

	private void seeCarList() {
		carListIt = carList.listIterator();
		
		while(carListIt.hasNext()){
			System.out.println(carListIt.next().toString());
			System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
		}
		
	}

	

}
