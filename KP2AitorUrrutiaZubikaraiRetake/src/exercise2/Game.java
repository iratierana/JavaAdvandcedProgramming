package exercise2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

	ArrayList<Criature> criatureList;
	ArrayList<Artefact> artefactList;
	
	public Game(){
		criatureList = new ArrayList<Criature>();
		artefactList = new ArrayList<Artefact>();
	}
	
	public void gameCicle(){
		Scanner keyboard = new Scanner(System.in);
		String name;
		int value;
		int option1, option2, option3;
		
		do{
		
			System.out.println("1. Create Artefact\n");
			System.out.println("2. Create Criature\n");
			System.out.println("3. Show Criature\n");
			System.out.println("4. Play\n");
			System.out.println("0. Exit\n");
			option1 = keyboard.nextInt(); keyboard.nextLine();
			switch(option1){
			case 1:
				System.out.println("Select Artefact:\n");
				System.out.println("1. Weapon\n");
				System.out.println("2. Poison\n");
				System.out.println("3. Potion\n");
				option2 = keyboard.nextInt(); keyboard.nextLine();
				System.out.println("Name: ");
				name = keyboard.nextLine();
				System.out.println("Value: ");
				value = keyboard.nextInt(); keyboard.nextLine();
				if(option2 == 1) artefactList.add(new Weapon(name, value));
				if(option2 == 2) artefactList.add(new Poison(name, value));
				if(option2 == 3) artefactList.add(new Potion(name, value));
				break;
			case 2:
				System.out.println("Select Criature:\n");
				System.out.println("1. Elf\n");
				System.out.println("2. Goblin\n");
				option2 = keyboard.nextInt(); keyboard.nextLine();
				System.out.println("Name: ");
				name = keyboard.nextLine();
				System.out.println("What artefact is going to use?");
				for(int i = 0; i < artefactList.size(); i++){
					System.out.println((i+1) + ". " + artefactList.get(i).toString() + "\n");
				}
				value = keyboard.nextInt(); keyboard.nextLine();
				if(option2 == 1) criatureList.add(new Elf(name, artefactList.get(value - 1)));
				if(option2 == 2) criatureList.add(new Goblin(name, artefactList.get(value - 1)));
				break;
			case 3:
				for(int i = 0; i < criatureList.size(); i++){
					System.out.println((i+1) + ". " + criatureList.get(i) + "\n");
				}
				break;
			case 4:
				do{
				playGame();
				System.out.println("Again? Yes(1)/No(0)");
				option3 = keyboard.nextInt(); keyboard.nextLine();
				}while(option3 == 1);
				break;
			}
		}while(option1!=0);
	}
	
	public void playGame(){
		Scanner keyboard = new Scanner(System.in);
		int criatureAttackId, criatureDefenseId, damage = 0;
		Random generator = new Random();
		
		System.out.println("Attacking: ");
		criatureAttackId = keyboard.nextInt(); keyboard.nextLine();
		System.out.println("Defending: ");
		criatureDefenseId = keyboard.nextInt(); keyboard.nextLine();
		
		if(criatureList.get(criatureAttackId - 1) instanceof Elf){
			if(criatureList.get(criatureAttackId - 1).artefact instanceof Weapon) damage = criatureList.get(criatureAttackId - 1).artefact.attack()*1;
			if(criatureList.get(criatureAttackId - 1).artefact instanceof Poison){
				if((criatureList.get(criatureAttackId - 1).artefact.attack()%2)==0){
					criatureList.get(criatureDefenseId - 1).health = "Poisoned";
					System.out.println("You have poisoned the enemy");
				}
				else{
					System.out.println("You have failed");
				}
			}
			if(criatureList.get(criatureAttackId - 1).artefact instanceof Potion){
				if((criatureList.get(criatureAttackId - 1).artefact.attack()%2)==0){
					criatureList.get(criatureDefenseId - 1).health = "Healty";
					System.out.println("You have put the enemy healthy");
				}
				else{
					System.out.println("You have failed");
				}
			}
		}
		if(criatureList.get(criatureAttackId - 1) instanceof Goblin){
			damage = criatureList.get(criatureAttackId - 1).artefact.attack()*2;
		}
		
		System.out.println("You have maked " + damage + " damage\n");
		
		criatureList.get(criatureDefenseId - 1).live = criatureList.get(criatureDefenseId - 1).live - damage;
	}
}
