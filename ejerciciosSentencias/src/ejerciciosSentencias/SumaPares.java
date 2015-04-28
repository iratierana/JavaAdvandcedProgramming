package ejerciciosSentencias;

public class SumaPares {
	
	public void sumarPar(){
		
		int suma = 0;
		
		System.out.println("La lista del 0 al 10 de pares es esta:");
		for(int kont = 0; kont<10 ; kont++){
			if((kont%2)==0){
				System.out.println(">"+kont);
				suma+=kont;
			}
		}	
		System.out.println("La suma de estos numeros pares es de "+suma);
	}

	public static void main(String[] args) {

		SumaPares ejercicio = new SumaPares();
		ejercicio.sumarPar();

	}
}
