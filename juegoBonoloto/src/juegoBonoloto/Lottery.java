package juegoBonoloto;

import java.util.Scanner;

	
public class Lottery {

	int numbers[];
	
	public void setNumbers(){
		
		Scanner keyboard = new Scanner (System.in); 
		numbers = new int [6]; 
		
		boolean correct = false;
		
		
		System.out.println("Introduce the numbers of the Lottery Ticket:");
		for(int kont = 0; kont<6 ; kont++){
			System.out.print(">");
			numbers[kont] = keyboard.nextInt(); keyboard.nextLine();	
			
			correct = true;
			for(int kont2 = 0; kont2<kont; kont2++){
				if(numbers[kont]==numbers[kont2]){
					correct = false;
					break;
				}
			}
			
			if(correct == false){
				System.out.println("The introduced value is not correct");
				kont--;
			}
			
		}	
		System.out.println("");
		System.out.println("");
	}	

	public int checkNumbers(Lottery ticket){
		int correct = 0;
		
		System.out.println("La lista es esta:");
		for(int i = 0; i<6 ; i++){
				
			for(int y = 0; y<6; y++){
				
				if(this.numbers[i]==ticket.numbers[y]){
					correct++;
					break;
				}
				
			}
			
		}
		
		return correct;
	}

}
