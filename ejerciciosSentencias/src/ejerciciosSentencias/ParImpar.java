package ejerciciosSentencias;

import java.util.Scanner;

public class ParImpar {
	
	int numero = 0;
	
	public void calcularParImpar(){
		Scanner teclado = new Scanner (System.in);
		
		System.out.print("Introduce un valor(de tipo int): ");
		numero = teclado.nextInt(); teclado.nextLine();
		
		if((numero%2)==0){
			System.out.println("El valor introducido es par");
		}
		else{
			System.out.println("El valor introducido es impar");
		}	
		
		
	}

	public static void main(String[] args) {

		ParImpar ejercicio = new ParImpar();
		ejercicio.calcularParImpar();

	}

}


