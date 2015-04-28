package ejerciciosSentencias;

import java.util.Scanner;

public class ImprimirNumerosAlReves {
	int numeros[];
	
	public void recogerNumeros(){
		Scanner teclado = new Scanner (System.in);
		numeros= new int[10];
		
		System.out.println("Introduce valores enteros aleatorios:");
		for(int kont = 0; kont<10 ; kont++){
			System.out.print(">");
			numeros[kont] = teclado.nextInt(); teclado.nextLine();	
			
		}		
	}
	
	public void imprimirNumeros(){
		
		System.out.println("La lista al reves es esta:");
		for(int kont = 9; kont>=0 ; kont--){
				
			System.out.println(">"+numeros[kont]);
			
		}		
	}

	public static void main(String[] args) {

		ImprimirNumerosAlReves ejercicio = new ImprimirNumerosAlReves();
		ejercicio.recogerNumeros();
		ejercicio.imprimirNumeros();
	}
}
