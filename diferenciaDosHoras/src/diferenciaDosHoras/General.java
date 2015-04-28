package diferenciaDosHoras;

import java.util.Scanner;

public class General {

	Hora hora[];
	
	public static void main(String[] args) {
		General ejercicio = new General();
		ejercicio.recogerHora();
	}

	public void recogerHora() {
		Scanner teclado = new Scanner (System.in);
		hora = new Hora[2];
		int horas, minutos;
		
		System.out.println("Introduce una hora:");
		System.out.println("Hora: ");
		horas = teclado.nextInt(); teclado.nextLine();
		System.out.println("Minutos: ");
		minutos = teclado.nextInt(); teclado.nextLine();
		
		minutos = conversor (horas, minutos);
		hora[0] = new Hora(minutos);
		System.out.println("Introduce otra hora:");
		System.out.println("Hora: ");
		horas = teclado.nextInt(); teclado.nextLine();
		System.out.println("Minutos: ");
		minutos = teclado.nextInt(); teclado.nextLine();
		
		minutos = conversor (horas, minutos);
		hora[1] = new Hora(minutos);
		
		minutos = hora[0].diferencia(hora[1].minutos);
		horas = 0;
		while(minutos>=60){
			minutos = minutos - 60;
			horas++;
		}
		
		System.out.println("La diferencia entre las dos horas es de "+horas+" horas y "+minutos+" minutos");
		
				
	}
	
	public int conversor (int horas, int minutos){
		
		while(horas > 0){
			horas--;
			minutos = minutos + 60;
		}
		
		return minutos;
	}

}
