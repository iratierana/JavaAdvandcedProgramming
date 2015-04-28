import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class functions {
	/*
	public void Menu(){
		Scanner keyboard = new Scanner (System.in);
		int option = 0;
		
		System.out.println("Title");
		
		do{
			System.out.println("1. ");
			System.out.println("2. ");
			System.out.println("3. ");
			System.out.println("4. ");
			System.out.println("5. ");
			System.out.println("6. ");
			System.out.println("7. ");
			System.out.println("0. Exit");
		
			option = keyboard.nextInt(); keyboard.nextLine();
			
			switch (option){	
			
			case 1:
				
			break;
			
			case 2:
				
			break;
			
			case 3:
				
			break;
			
			case 4:
				
			break;
			
			case 5:
				
			break;
			
			case 6:
					
			break;
			
			case 7:
					
			break;
			}
			
		}while (option!=0);
	}

	public void goOverList(ArrayList<Object> list){
		listIt = list.listIterator();
		
		while(listIt.hasNext()){
			System.out.println(listIt.hasNext().next().toString());
		}
	}

	public void askData(){
		Scanner keyboard = new Scanner (System.in);
		System.out.print("Int : ");
		int i = keyboard.nextInt(); keyboard.nextLine();
		
		System.out.print("Float : ");
		float f = keyboard.nextFloat(); keyboard.nextLine();
		
		System.out.print("String : ");
		String s = keyboard.nextLine();
		
		
	}

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
	*/
}
