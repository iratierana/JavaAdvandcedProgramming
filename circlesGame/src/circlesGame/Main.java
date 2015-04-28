package circlesGame;

import java.util.Scanner;

public class Main {
	
	Circle circles[];

	public static void main(String[] args) {
		Main exercise = new Main();
		Screen.screenMain();
		exercise.program();
	}

	public void program(){
		Scanner keyboard = new Scanner(System.in);
		Screen screen = new Screen();
		
		int puntuation = 0;
		boolean continuePlaying = false, hitEjecution = false;
		int continueP=0;
		int x = 0, y = 0, speedX = 0,speedY = 0;
		circles = new Circle[10];
		
		
		for (int i=0; i<10; i++){
			circles[i] = new Circle();
		}
		
		System.out.println("***Game Introduction***");
		System.out.println("> You are in the middle down of the screen, position (x,y) = (320,0)");
		System.out.println("> You will have 3 opportunities to hit the circles");
		System.out.println("> To hit the circles, you will have to introduce the speed of the hit (it can be negative)");
		
		do{
			for(int i=0;i<3;i++){
				System.out.println("Shoot "+ (i+1));
				
				System.out.println("Introduce the x range speed: ");
				speedX = keyboard.nextInt(); keyboard.nextLine();
				if((0<speedX)&&(speedX<10)){
					speedX=10;
				}
				System.out.println("Introduce the y range speed: ");
				speedY = keyboard.nextInt(); keyboard.nextLine();
				if((0<speedY)&&(speedY<10)){
					speedY=10;
				}
				hitEjecution = true;
				
				for(int w=0; w<10; w++){
					if(circles[w].checkHit(x, y)){
						hitEjecution = false;
						puntuation++;
						System.out.println("Circle hitted");
					}
				}
				
				while(hitEjecution==true){
					x = x + (int)(speedX*0.1);
					y = y + (int)(speedY*0.1);
					for(int w=0; w<10; w++){
						if(circles[w].checkHit(x, y)){
							hitEjecution = false;
							puntuation++;
							System.out.println("Circle hitted");
						}
					}
					
					if((x>639)||(x<0)||(y>479)||(y<0)){
						hitEjecution = false;
					}
					
				}
				System.out.println("");
			}
			System.out.println("Puntuation: "+puntuation);
			System.out.println("");
			System.out.println("Continue playing: Yes(1)/No(0)");
			continueP = keyboard.nextInt(); keyboard.nextLine();
			
			if(continueP == 1){
				continuePlaying = true;
				puntuation = 0;
			}
			else{
				continuePlaying = false;
			}
			
			
		}while(continuePlaying==true);
		
		
	}

	
}
