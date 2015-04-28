package compareHour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	Hour hour;
	ArrayList<Hour> hours;
	ListIterator<Hour> hoursIt;

	public static void main(String[] args) {
		Main program = new Main();
		program.menu();
		

	}
	
	public void menu() {
		int option = 0;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("1. Two hours comparation");
		System.out.println("2. More than two hours comparation");
		System.out.println("0. Exit");
		option = keyboard.nextInt(); keyboard.nextLine();
		
		switch(option){
		case 1:
			comparationTwoHours();
			break;
			
		case 2:
			comparationUndefinedHours();
			break;
		}
		
	}

	public void comparationTwoHours(){
		Hour hour = new Hour(0, 0);
		takeHour(hour);
		Hour hour1 = new Hour(hour.hour, hour.minute);
		takeHour(hour);
		Hour hour2 = new Hour(hour.hour, hour.minute);
		
		
		switch(hour1.compareHour(hour2)){
		case -1: 
			System.out.println("The second hour is earlier");
			System.out.println(hour2 + " < " + hour1);
			break;
		case 0:
			System.out.println("The two hours are the same");
			System.out.println(hour1 + " = " + hour2);
			break;
		case +1:
			System.out.println("The first hour is earlier");
		System.out.println(hour1 + " < " + hour2);
			break;
		}
	}

	public void comparationUndefinedHours() {
		Scanner keyboard = new Scanner(System.in);
		int option = 0;
		MyComparator myComparator = new MyComparator();
	
		hours = new ArrayList<Hour>();
		
		do{
			hour = new Hour(0,0);
			takeHour(hour);
			hours.add(hour);
			
			
			System.out.println("Introduce another hour? (Yes(1)/No(0)): ");
			option = keyboard.nextInt(); keyboard.nextLine();
		}while(option!=0);
			
		Collections.sort(hours, myComparator);
		
		hoursIt = hours.listIterator();
		
		while(hoursIt.hasNext()){
			System.out.println(hoursIt.next().toString());
		}
		
	}
	
	public void takeHour(Hour hour){
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Introduce an hour (hh mm)");
		hour.hour = keyboard.nextInt();
		hour.minute = keyboard.nextInt(); keyboard.nextLine();
		
	}
	
}
