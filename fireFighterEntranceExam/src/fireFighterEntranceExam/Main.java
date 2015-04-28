package fireFighterEntranceExam;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;


public class Main {

	ArrayList<FireFighter> fireFighterList;
	ListIterator<FireFighter> fireFighterListIt;;
	
	public static void main(String[] args) {
		Main program = new Main();
		program.menu();

	}

	private void menu() {
		Scanner keyboard = new Scanner(System.in);
		int option = 0;
		fireFighterList = new ArrayList<FireFighter>();
		
		do{
			System.out.println("No esta terminado por falta de tiempo");
			System.out.println("***FireFighter Entrance Exam Program***");
			System.out.println("1. Introduce FireFighter");
			System.out.println("2. See all FireFighters");
			System.out.println("0. Exit");
			option = keyboard.nextInt(); keyboard.nextLine();
			
			switch(option){
			case 1: addFireFighter();
				break;
			case 2: seeFireFighterList();
				break;
			}
			
			
		}while(option!=0);
		
	}

	

	private void addFireFighter() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Genere(Male(1)/Female(0)): ");
		int genere = keyboard.nextInt(); keyboard.nextLine();
		
		if(genere == 1){
			Boy fireFighter = new Boy();
			fireFighter.askData();
			fireFighterList.add(fireFighter);
		}
		else{
			Girl fireFighter = new Girl();
			fireFighter.askData();
			fireFighterList.add(fireFighter);
		}
		
	}
	
	private void seeFireFighterList() {
		fireFighterListIt = (ListIterator<FireFighter>) fireFighterList.iterator();
		while(fireFighterListIt.hasNext()){
			System.out.println(fireFighterListIt.toString);
		}
	}


}
