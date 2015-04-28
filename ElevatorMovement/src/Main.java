import java.util.Scanner;


public class Main {
	
	Elevator elevators[];

	public static void main(String[] args) {
		Main exercise = new Main();
		exercise.menu();

	}
	public void menu(){
		int option = 0;
		Scanner keyboard = new Scanner(System.in);
		int floor = 0, elevator = 0;
		
		elevators = new Elevator[3];
		
		elevators[0]= new Elevator(0, "A", false);
		elevators[1]= new Elevator(0, "B", false);
		elevators[2]= new Elevator(0, "C", false);
		
		System.out.println("***Welcome to the elevator movement administration***");
		do{
			floor = 0;
			elevator = 0;
			
			System.out.println("1. Move elevator to");
			System.out.println("2. Call elevator");
			System.out.println("0. Exit");
			
			option = keyboard.nextInt(); keyboard.nextLine();
			
			switch (option){
			
			case 1:
				System.out.print("Introduce your elevator number: A(0), B(1), C(2) ");
				elevator = keyboard.nextInt(); keyboard.nextLine();
				System.out.print("Introduce the floor you want to go: ");
				floor = keyboard.nextInt(); keyboard.nextLine();
				elevators[elevator].setFloor(floor);
				
				break;
			case 2:
				System.out.print("Introduce the floor you are: ");
				floor = keyboard.nextInt(); keyboard.nextLine();
				
				for(int i=0; i<3; i++){
					if(elevators[i].distance(floor) < elevators[elevator].distance(floor)){
						elevator = i;
					}
				}
				System.out.println("You have to enter the "+elevators[elevator].name+" elevator");
				elevators[elevator].setFloor(floor);
				
				
				break;
			}
			
		}while (option!=0);
	}

}
