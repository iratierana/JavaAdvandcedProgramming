package calendarioCumpleaños;

import java.util.Scanner;

public class Main {

	Birthday dates[];
	
	public static void main(String[] args) {
		Main exercise = new Main();
		exercise.menu();
		

	}
	
	public void menu(){
		Scanner keyboard = new Scanner (System.in);
		dates= new Birthday[100];
		
		int option = 0, number = 0;
		
		int year = 0, month = 0, day = 0;
		
		String name;
			
		
		do{
			System.out.println("1. Introduce birthday");
			System.out.println("2. Introduce day");
			System.out.println("0. Exit");

			option = keyboard.nextInt(); keyboard.nextLine();
			
			if(option!=0){
			
				System.out.println("Introduce the date:");
				System.out.print("Day:");
				day = keyboard.nextInt(); keyboard.nextLine();
				System.out.print("Month:");
				month = keyboard.nextInt(); keyboard.nextLine();
				System.out.print("Year:");
				year = keyboard.nextInt(); keyboard.nextLine();
			
			}
			
			switch(option){
			case 1:

				if(Birthday.checkBirthday(year, month, day) == true){
					System.out.print("Introduce the name:");
					name = keyboard.nextLine();
					dates[number] = new Birthday();
					if(dates[number].setBirthday(year, month, day, name)){
						number++;	
					}
				}
				else{
					System.out.println("The date you have introduced is not correct");
				}
				
			break;
				
			case 2:
				
				if(Birthday.checkBirthday(year, month, day) == true){
					for(int i=0; i<number;i++){
						
						if(dates[0].getBirthday(year, month, day)){
							System.out.println("Today is "+dates[0].name+ "'s birthday");
						}
						
					}
				}
				else{
					System.out.println("The date you have introduced is not correct");
				}
				
				
			break;
			
			}
			
		}while((option != 0)&&(number<100));

	}
}

