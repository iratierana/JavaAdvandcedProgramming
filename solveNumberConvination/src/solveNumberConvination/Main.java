package solveNumberConvination;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	ArrayList<Number> numberList = null;
	
	public static void main(String[] args) {
		Main program = new Main();
		program.doArrayList();
		program.findNumber();
	}

	public void doArrayList() {
		Number number;
		ArrayList<Number> numberList = new ArrayList<Number>();


		int digit1 = 0;
		int digit2 = 0;
		int digit3 = 0;
		int digit4 = 0;
		
		
		
		for(int i=0; i<10000; i++){
			
			digit1 = i/1000;
			digit2 = (i - digit1*1000)/100;
			digit3 = (i - digit1*1000 - digit2*100)/10;
			digit4 = i - digit1*1000 - digit2*100 - digit3*10;
			if(checkNumber(digit1, digit2, digit3, digit4)){
				number = new Number(digit1, digit2, digit3, digit4);
				numberList.add((Number)number);
			}
		}
	}
	
	public void findNumber() {
		Scanner keyboard = new Scanner(System.in);
		Random generator = new Random();
		int killed = 0;
		int injuried = 0;
		boolean finished = false;
		Number number;
		Number baseNumber;
		int randomNumber = 0;
		
		int aux=0;
		
		
		
		while(finished == false){
			//FIND NUMBER TO ASK 
			aux = numberList.size();
			randomNumber = generator.nextInt( aux);
			
			//ASK NUMBER
			
			baseNumber = numberList.get(randomNumber);
			
			System.out.println("The number: " +baseNumber.digit1+ +baseNumber.digit2+ +baseNumber.digit3+ +baseNumber.digit4);
			
			System.out.println("Injuried: ");
			injuried = keyboard.nextInt(); keyboard.nextLine();
			
			System.out.print("Killed: ");
			killed = keyboard.nextInt(); keyboard.nextLine();
			
			ListIterator<Number> it = numberList.listIterator();
			
			while(it.hasNext()){
				number = it.next();
				if(!checkKilled(baseNumber, number, killed)){
					it.remove();
				}
				
				else{
					if(!checkInjuried(baseNumber, number, injuried)){
						it.remove();
					}
				}
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public boolean checkInjuried(Number base, Number number, int injuried){
		int numberInjuried = 0;
		
		if(base.digit1 == number.digit2){
			numberInjuried++;
		}
		if(base.digit1 == number.digit3){
			numberInjuried++;
		}
		if(base.digit1 == number.digit4){
			numberInjuried++;
		}
		
		if(base.digit2 == number.digit1){
			numberInjuried++;
		}
		if(base.digit2 == number.digit3){
			numberInjuried++;
		}
		if(base.digit2 == number.digit4){
			numberInjuried++;
		}
		if(base.digit3 == number.digit1){
			numberInjuried++;
		}
		if(base.digit3 == number.digit2){
			numberInjuried++;
		}
		if(base.digit3 == number.digit4){
			numberInjuried++;
		}
		
		if(numberInjuried == injuried){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean checkKilled(Number base, Number number, int killed){
		int numberKilled = 0;
		
		if(base.digit1 == number.digit1){
			numberKilled++;
		}
		if(base.digit2 == number.digit2){
			numberKilled++;
		}
		if(base.digit3 == number.digit3){
			numberKilled++;
		}
		if(base.digit4 == number.digit4){
			numberKilled++;
		}
		
		if(numberKilled == killed){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void deleteNumbers(int digit){
		
		
	}
	
	
	
	public boolean checkNumber(int digit1, int digit2, int digit3, int digit4){
		boolean correct = true;
		
		if(digit1==digit2){
			correct = false;
		}
		if(digit1==digit3){
			correct = false;
		}
		if(digit1==digit4){
			correct = false;
		}
		
		if(digit2==digit3){
			correct = false;
		}
		if(digit2==digit4){
			correct = false;
		}
		
		if(digit3==digit4){
			correct = false;
		}
		
		return correct;
	}

}
