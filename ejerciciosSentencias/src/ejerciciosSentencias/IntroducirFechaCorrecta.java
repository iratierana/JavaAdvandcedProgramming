package ejerciciosSentencias;

import java.util.Scanner;

public class IntroducirFechaCorrecta {

	
	int fecha[];
	
	public void recogerFecha(){
		Scanner teclado = new Scanner (System.in);
		fecha= new int[3];
		boolean correcto = false;
		boolean bisiesto = false;
		int limite=0;
		
		do{
		correcto = false;
		bisiesto = false;
		
		System.out.println("Introduce la fecha:");
		System.out.print("Dia:");
		fecha[0] = teclado.nextInt(); teclado.nextLine();
		System.out.print("Mes:");
		fecha[1] = teclado.nextInt(); teclado.nextLine();
		System.out.print("Año:");
		fecha[2] = teclado.nextInt(); teclado.nextLine();
		
		if(fecha[2]>=0){
			if((fecha[2]%4)==0){
				bisiesto = true;
			}
			if((fecha[1]>0)&&(fecha[1]<=12)){
				
				switch(fecha[1]){
					case 2: 
						if(bisiesto == true){
							limite=29;
						}
						if (bisiesto == false){
							limite=28;	
						}
						break;
					case 4: limite=30;
						break;
					case 6: limite=30;
						break;
					case 9: limite=30;
						break;
					case 11: limite=30;
						break;
					default: limite=31;
						break;
				}
				if(fecha[0]<=limite){
					correcto = true;
				}
			}
		}
		
		}while(correcto==false);
		
		
		System.out.println("");
		System.out.println("");
	}
	
	public void imprimirFecha(){
		System.out.println(+fecha[2] +" / "+fecha[1] +" / "+fecha[0]);
	}
	
	
	public static void main(String[] args) {
		
		IntroducirFechaCorrecta ejercicio = new IntroducirFechaCorrecta();
		ejercicio.recogerFecha();
		ejercicio.imprimirFecha();
		
	}

}
