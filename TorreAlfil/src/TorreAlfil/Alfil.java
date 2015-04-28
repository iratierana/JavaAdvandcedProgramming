package TorreAlfil;

import java.util.Scanner;

public class Alfil {

	int x = 1;
	int y = 1;
	
	public void get(){
		System.out.println("Posicion alfil: (" + this.x + "," + this.y + ")");
	}
	
	public void set(){
		
		Scanner teclado = new Scanner (System.in);
		
		boolean correcto = false;
		int x=0, y=0;
		int dx=0, dy=0;
		
		do{
			correcto = false;
			this.get();
			System.out.println("Introduzca las coordenadas: (el tablero es de 10x10)");
			System.out.print("X = ");
			x = teclado.nextInt(); teclado.nextLine();
			System.out.print("Y = ");
			y = teclado.nextInt(); teclado.nextLine();
			
			dx = x - this.x;
			dy = y - this.y;
			if(dx<0){
				dx = dx * (-1);
			}
			if(dy<0){
				dy = dy * (-1);
			}
			
			if((dx != 0)&&(dy != 0)){
				if(dx==dy){
					correcto = true;
				}
			}
			
			if( correcto == false){
				System.out.println("Las coordenadas introducidas no son correctas, pruebe otra vez");
			}
			if( correcto == true){
				this.x = x;
				this.y = y;
			}
			
			
		
		}while(correcto==false);
		
	}
	
}
