package telephoneBook;

import java.util.Scanner;

public class Main {
	
	Contact contacts[];

	public static void main(String[] args) {
		Main exercise = new Main();
		exercise.menu();

	}
	
	public void menu(){
		
		Scanner keyboard = new Scanner (System.in);
		int option = 0;
		contacts = new Contact[100];
		long number = 0;
		String name;
		int contactNumber = 0;
		
		do{
			System.out.println("1. Introduce contact");
			System.out.println("2. Find contact");
			System.out.println("0. Exit");
		
			option = keyboard.nextInt(); keyboard.nextLine();
			
			switch (option){	
			case 1:
				if( contactNumber<100){
					System.out.print("Number: ");
					number = keyboard.nextLong(); keyboard.nextLine();
					System.out.print("Name: ");
					name = keyboard.nextLine();
					contacts[contactNumber]= new Contact(number, name);
					contactNumber++;
				}
				else{
					System.out.println("Too much contacts");
				}
				
				
			break;
			case 2:
				System.out.print("Name: ");
				name = keyboard.nextLine();
				for(int i=0; i<contactNumber; i++){
					if(contacts[i].findContact(name)){
						System.out.println(">"+contacts[i].name+": "+contacts[i].number);
					}
				}
				
			break;
			}
						
		}while (option!=0);
	
	}

}
