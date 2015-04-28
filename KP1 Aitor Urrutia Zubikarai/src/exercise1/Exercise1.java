package exercise1;

import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
	
	Integer[][] yard;

	public static void main(String[] args) {
		Exercise1 exercise = new Exercise1();
		exercise.initialize();
		while(exercise.game()){
			System.out.println("------");
		}

	}

	private boolean game() {
		Scanner keyboard = new Scanner (System.in);
		boolean startGame = true;
		int posX, posY;
		int mine;
		int value;
		
		System.out.print("Introduce position X: ");
		posX = keyboard.nextInt(); keyboard.nextLine();
		System.out.print("Introduce position Y: ");
		posY = keyboard.nextInt(); keyboard.nextLine();
		
		System.out.print("Mine: Yes(1)/No(0): ");
		mine = keyboard.nextInt(); keyboard.nextLine();
		
		if(mine==1){
			if(yard[posX-1][posY-1]==1){
				yard[posX-1][posY-1] = -1;
				System.out.println("Well done, mine detected");
			}
			if(yard[posX-1][posY-1]==0){
				System.out.println("Oh, you failed");
				return false;
			}
		}
		if(mine==0){
			if(yard[posX-1][posY-1]==1){
				System.out.println("Oh no, a mine has exploted");
				return false;
			}
			if(yard[posX-1][posY-1]==0){
				System.out.println("Well done");
				//value
				System.out.println("This position value is: " + value(posX-1, posY-1));
				
			}
		}
		
		//comprobar campo
		for(int x=0; x<10; x++){
			for(int y=0;y<10;y++){
				if(yard[x][y]==1){
					return true;
				}
			}
		}
		System.out.println("Congratulations, You win");
		return false;
		
	}

	private void initialize() {
		boolean done;
		int posX, posY;
		yard = new Integer[10][10];
		
		for(int x=0; x<10; x++){
			for(int y=0;y<10;y++){
				yard[x][y] = new Integer(0);
				yard[x][y]=0;
			}
		}
		
		for(int i=0; i<20;i++){
			done = false;
			while(done==false){
				posX = randomNumberGenerator();
				posY = randomNumberGenerator();
				if(yard[posX][posY]==0){
					yard[posX][posY] = 1;
					done = true;
					System.out.println(posX + " , " + posY);
				}
			}
		}
		
	}
	
	public int randomNumberGenerator(){
		Random generator = new Random();
		
		int randomNumber = generator.nextInt(10);
		
		return randomNumber;
	}

	public int value(int posX, int posY){
		int value = 0;
		if(posX>0){
			if(yard[posX-1][posY]==1){
				value++;
			}
		}
		if(posX<9){
			if(yard[posX+1][posY]==1){
				value++;
			}
		}
		if(posY>0){
			if(yard[posY][posY-1]==1){
				value++;
			}
		}
		if(posY<9){
			if(yard[posY][posY+1]==1){
				value++;
			}
		}
		return value;
	}
}
