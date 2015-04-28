package ejerciciosSentencias;

import java.util.Scanner;

public class NumeroPrimo {
	
	public void encontrarPrimo(){
		
		int numero = 0;
		int kont = 0;
		
		Scanner teclado = new Scanner (System.in);
		
		System.out.print("Introduce un valor(de tipo int): ");
		numero = teclado.nextInt(); teclado.nextLine();	
		
		for(kont=2;kont<numero;kont++){
			if((numero%kont)==0){
				System.out.println("El valor introducido no es primo");
				break;
			}
		}
		if(numero==kont){
			System.out.println("El valor introducido es primo");
		}
	}

	public static void main(String[] args) {

		NumeroPrimo ejercicio = new NumeroPrimo();
		ejercicio.encontrarPrimo();

	}
}
