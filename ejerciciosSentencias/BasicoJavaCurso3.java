/**
 * Esta clase sirve para ver los tipos básicos de java y los operadores a utilizar. <p>
 * 
 * Las variables siempre empiezan con minúscula. Si el nombre es compuesto se separan las palabras
 * con mayúsculas. Por ejemplo: puertoSerie, valorInicial, ...
 * El nombre de una variable siempre empieza con un carácter alfabético, $ o _ pero estos
 * últimos no utilizar. <p>
 * 
 * @author txperez
 * @version 1.0
 *
 */
public class BasicoJavaCurso3 {
	
	byte opByte = 5; 								// 1 Byte
	short opShort = 30000;							// 2 Bytes
	int  opInt = 12345678;							// 4 Bytes
	int opInt2 = 0xFFFF;
	long opLong = 123445678987654321L;				// 8 Bytes
	float opFloat = 3.5F;							// 4 Bytes
	double opDouble= 3.5;							// 8 Bytes
	char opChar;									// 2 Bytes  UNICODE
	boolean opBool;									// (true/false) indeterminado

	/**
	 * Esta función sirve para dar un repaso a los operadores aritméticos.
	 * Muestra la necesidad de usar operador cast en las operaciones aritméticas
	 * que implican un cambio de tipo.
	 */
	public void gestionOperadoresAritmeticos () {
		int a = 10;
		int b = 4;
		int c ;
		float x;
		//Operador asignación
		opInt = opInt2;
		//operadores aritmeticos + - * / % 
		
		c = a/b;
		System.out.println( "el valor es: "+c);
		x = (float) a/b ;
		System.out.println ("el valore es: "+x);
		
		
	}
	/**
	 * Engloba los operadores unarios y las contracciones aritmeticas.
	 * Es importante conocer la diferencia de utilizar los operadores
	 * ++ y -- antes de la variable y despues de la variable.
	 */
	public void gestionOperadoresUnarios() {
		//operadores unarios ++ --  +=  -=  *=  /=  %=  !
		int contador = 5;
		System.out.println ("El valor es: "+contador++); //ejecuta contador = contador+1; despues de esta sentencia
		System.out.println ("El valor es: "+ (++contador)); // ejecuta contador = contador+1; antes de esta sentencia
		System.out.println ("El valor es: "+ contador+3);
		contador += 5; // contador = contador +5;
	}
	/**
	 * Muestra que los operaciones relaciones siempre devuelven un valor booleano.
	 */
	public void gestionOperadoresRelaciones(){
		//operadores relacionales > < == != >= <= 
		// dan como resultado un valor booleano true/false
		int a = 5;
		int b = 7;
		System.out.println("El resultado es :" + (a>b));
	}
	/**
	 * Son operadores que combinan operadores booleanos
	 */
	public void gestionOperadoresLogicos() {
		//Operadores lógicos && || 
		int a = 5;
		int b = 5;
		
		if (!(a>b) && !(b>a)){
			System.out.println("Son iguales");
		}
	}
	/**
	 * Un operador muy utilizado que permite asignar una valor u otro en base a una condición.
	 */
	public void gestionOperadorIf(){
		//operador If   ? :
		int a = 5;
		int b = 7;
		int c;
		c = (a>b) ? 6 : 8;
		
		System.out.println("El valor es: "+c);
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BasicoJavaCurso3 programa = new BasicoJavaCurso3();
		programa.gestionOperadoresUnarios();
	
	}

}
