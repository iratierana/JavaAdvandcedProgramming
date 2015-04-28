package ejerciciosSentencias;

import java.util.Scanner;

public class Bonoloto {

	int numerosJugada[];
	int numerosBoleto[];
	
	public void recogerNumerosJugada(){
		Scanner teclado = new Scanner (System.in);
		numerosJugada= new int[6];
		boolean egokia = false;
		
		System.out.println("Introduce los numeros de la jugada:");
		for(int kont = 0; kont<6 ; kont++){
			System.out.print(">");
			numerosJugada[kont] = teclado.nextInt(); teclado.nextLine();	
			
			egokia = true;
			for(int kont2 = 0; kont2<kont; kont2++){
				if(numerosJugada[kont]==numerosJugada[kont2]){
					egokia = false;
					break;
				}
			}
			
			if(egokia == false){
				System.out.println("El valor introducido no es correcto");
				kont--;
			}
			
		}
		System.out.println("");
		System.out.println("");
	}
	
	public void recogerNumerosBoleto(){
		Scanner teclado = new Scanner (System.in);
		numerosBoleto= new int[6];
		boolean egokia = false;
		
		
		System.out.println("Introduce los numeros del boleto:");
		for(int kont = 0; kont<6 ; kont++){
			System.out.print(">");
			numerosBoleto[kont] = teclado.nextInt(); teclado.nextLine();	
			
			egokia = true;
			for(int kont2 = 0; kont2<kont; kont2++){
				if(numerosBoleto[kont]==numerosBoleto[kont2]){
					egokia = false;
					break;
				}
			}
			
			if(egokia == false){
				System.out.println("El valor introducido no es correcto");
				kont--;
			}
			
		}	
		System.out.println("");
		System.out.println("");
	}
	
	
	public void comprovarNumeros(){
		int correctos = 0;
		
		System.out.println("La lista es esta:");
		for(int i = 0; i<6 ; i++){
				
			for(int y = 0; y<6; y++){
				
				if(numerosBoleto[i]==numerosJugada[y]){
					correctos++;
					break;
				}
				
			}
			
		}
		
		System.out.println("La cantidad de numeros acertados: "+correctos);
	}
	
	public static void main(String[] args) {

		Bonoloto ejercicio = new Bonoloto();
		ejercicio.recogerNumerosJugada();
		ejercicio.recogerNumerosBoleto();
		ejercicio.comprovarNumeros();
	}
	
}
