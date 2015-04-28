package ejerciciosSentencias;

import java.util.Scanner;

public class LeerNumerosDiferentes {

	int numeros[];
	
	public void recogerNumeros(){
		Scanner teclado = new Scanner (System.in);
		numeros= new int[10];
		boolean egokia = false;
		

		for(int kont = 0; kont<10 ; kont++){
			System.out.print(">");
			numeros[kont] = teclado.nextInt(); teclado.nextLine();	
			
			egokia = true;
			for(int kont2 = 0; kont2<kont; kont2++){
				if(numeros[kont]==numeros[kont2]){
					egokia = false;
					break;
				}
			}
			
			if(egokia == false){
				System.out.println("Sartutako zenbakia ez da egokia");
				kont--;
			}
			
		}		
	}
	
	public void imprimirNumeros(){
		
		System.out.println("La lista es esta:");
		for(int kont = 0; kont<10 ; kont++){
				
			System.out.println(">"+numeros[kont]);
			
		}		
	}
	
	public static void main(String[] args) {

		LeerNumerosDiferentes ejercicio = new LeerNumerosDiferentes();
		ejercicio.recogerNumeros();
		ejercicio.imprimirNumeros();
	}
	
}
