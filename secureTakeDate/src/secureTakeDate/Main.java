package secureTakeDate;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	Date date;
	
	public void takeDate(){
		Scanner keyboard = new Scanner (System.in);
		int year = 0, month = 0, day = 0;
		boolean correct = false;
		int election = 0;
		
		while(!correct){		
			try {
				System.out.print("Introduce the date (yyyy mm dd): ");
				year = keyboard.nextInt();
				month = keyboard.nextInt();
				day = keyboard.nextInt(); keyboard.nextLine();
				date = new Date(year, month, day);
				correct = true;
				
			} catch (IOException e){
				System.out.println ("Excepcion handling code for the Entry");
				
			} catch (InputMismatchException e){	
				System.out.println ("The format is yyyy mm dd");
				keyboard.nextLine();

			} catch(NullPointerException e) {
				  System.out.println("Exception handling code for the NullPointerException.");
			
			} catch(NumberFormatException e) {
				  System.out.println("Exception handling code for the NumberFormatException.");
			
			} catch(ArithmeticException e) {
				  System.out.println("Exception handling code for ArithmeticException");
				  
			} catch(IndexOutOfBoundsException e) {
				  System.out.println("Exception handling code for IndexOutOfBoundsException.");
			
			} catch(EmptyStackException e) {
				  System.out.println("Exception handling code for EmptyStackException");
			
		    } catch (Exception e) {
		    	System.out.println(e.getMessage());
		    }
		}
		
		
		System.out.println("");
		System.out.println("");
	}
	
	public void printDate(){
		System.out.println(date.year +" / "+date.month +" / "+date.day);
	}
	
	
	public static void main(String[] args) {
		
		Main program = new Main();
		program.takeDate();
		program.printDate();
		
	}

}
