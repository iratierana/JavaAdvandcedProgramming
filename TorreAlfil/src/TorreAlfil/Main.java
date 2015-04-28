package TorreAlfil;

import java.util.Scanner;

public class Main {
	
	Torre torre;
	Alfil alfil;

	public static void main(String[] args) {
		
		Main ejercicio = new Main();
		ejercicio.menu();

	}
	
	public void menu(){
		Scanner teclado = new Scanner (System.in);
		int opcion = 1;
		Torre torre = new Torre();
		Alfil alfil = new Alfil();
		
		do{
			System.out.println("Elija una opcion: ");
			System.out.println("1. Ver coordenadas torre");
			System.out.println("2. Ver coordenadas alfil");
			System.out.println("3. Mover torre");
			System.out.println("4. Mover alfil");
			System.out.println("0. Salir");
			opcion = teclado.nextInt(); teclado.nextLine();
			
			switch(opcion){
			case 1: torre.get();
				break;
			case 2:alfil.get();
				break;
			case 3:torre.set();
				break;
			case 4:alfil.set();
				break;
			}
			
		}while(opcion!=0);
		
	}

}
