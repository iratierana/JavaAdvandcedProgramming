package ejerciciosSentencias;

import java.util.Scanner;

public class ImprimirDebajoMedia {

	int numeros[];
	float media;
	
	public void recogerNumeros(){
		Scanner teclado = new Scanner (System.in);
		numeros= new int[10];
		
		System.out.println("Introduce valores enteros aleatorios:");
		for(int kont = 0; kont<10 ; kont++){
			System.out.print(">");
			numeros[kont] = teclado.nextInt(); teclado.nextLine();
			media = media + numeros[kont];
						
		}	
		media = media / 10;
		System.out.println(+media);
	}
	
	public void imprimirNumeros(){

		System.out.println("La lista de los que estan por debajo de la media es esta:");
		for(int kont = 9; kont>=0 ; kont--){
			if(numeros[kont]<media){
				System.out.println(">"+numeros[kont]);	
			}
			
		}		
	}

	public static void main(String[] args) {

		ImprimirDebajoMedia ejercicio = new ImprimirDebajoMedia();
		ejercicio.recogerNumeros();
		ejercicio.imprimirNumeros();
	}
	
}
