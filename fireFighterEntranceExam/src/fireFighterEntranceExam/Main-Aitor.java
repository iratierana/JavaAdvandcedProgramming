package fireFighterEntranceExam;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;


public class Main {

	ArrayList<FireFighter> fireFighterList;
	ListIterator<FireFighter> fireFighterListIt;
	
	public static void main(String[] args) {
		Main program = new Main();
		program.menu();

	}

	private void menu() {
		Scanner keyboard = new Scanner(System.in);
		int option = 0;
		String genere = null;
		fireFighterList = new ArrayList<FireFighter>();
		
		do{
			System.out.println("***FireFighter Entrance Exam Program***");
			System.out.println("1. Introduce FireFighter");
			System.out.println("2. See all FireFighters");
			System.out.println("0. Exit");
			option = keyboard.nextInt(); keyboard.nextLine();
			
			switch(option){
			case 1: 
				System.out.print("Genere(Male(M)/Female(F)): ");
				genere = keyboard.nextLine();
				if(genere.equalsIgnoreCase("M")){
					Boy fireFighter = new Boy();
					fireFighter.introduceData();
					fireFighterList.add(fireFighter);
				}
				if(genere.equalsIgnoreCase("F")){
					Girl fireFighter = new Girl();
					fireFighter.introduceData();
					fireFighterList.add(fireFighter);
				}
				break;
			case 2: seeFireFighterList();
				break;
			}
			
			
		}while(option!=0);
		
	}
	
	private void seeFireFighterList() {
		fireFighterListIt = fireFighterList.listIterator();
		
		while(fireFighterListIt.hasNext()){
			System.out.println(fireFighterListIt.next().toString());
		}
		
	}


}
