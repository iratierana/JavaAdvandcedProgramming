package ejerciciosSentencias;

import java.util.Scanner;

public class ImprimirImpares {
	
	public void imprimirImpar(){
	
		//imprimatzeko
		System.out.println("La lista del 0 al 10 de impares es esta:");
		for(int kont = 0; kont<10 ; kont++){
			if((kont%2)==1){
				System.out.println(">"+kont);
			}
		}		
	}

	public static void main(String[] args) {

		ImprimirImpares ejercicio = new ImprimirImpares();
		ejercicio.imprimirImpar();

	}
}
