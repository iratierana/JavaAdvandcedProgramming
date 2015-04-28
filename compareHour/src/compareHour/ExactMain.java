package compareHour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Scanner;

public class ExactMain {

	ExactHour exactHour;
	ArrayList<ExactHour> exactHours;
	ListIterator<ExactHour> exactHoursIt;

	public static void main(String[] args) {
		ExactMain program = new ExactMain();
		program.comparationUndefinedExactHours();
		

	}

	public void comparationUndefinedExactHours() {
		Scanner keyboard = new Scanner(System.in);
		int option = 0;
		MyComparator myComparator = new MyComparator();
	
		exactHours = new ArrayList<ExactHour>();
		
		do{
			exactHour = new ExactHour(0,0,0);
			takeExactHour(exactHour);
			exactHours.add(exactHour);
			
			
			System.out.println("Introduce another hour? (Yes(1)/No(0)): ");
			option = keyboard.nextInt(); keyboard.nextLine();
		}while(option!=0);
			
		Collections.sort(exactHours, myComparator);
		
		exactHoursIt = exactHours.listIterator();
		
		while(exactHoursIt.hasNext()){
			System.out.println(exactHoursIt.next().toString());
		}
		
	}
	
	public void takeExactHour(ExactHour exactHour){
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Introduce an hour (hh mm ss)");
		exactHour.hour = keyboard.nextInt();
		exactHour.minute = keyboard.nextInt();
		exactHour.seconds = keyboard.nextInt(); keyboard.nextLine();
		
	}

}
