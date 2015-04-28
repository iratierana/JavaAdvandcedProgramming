package fileStudentsMark;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;


public class GestorClase implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -7729075806430308900L;
	Clase clase;
	Scanner teclado;
	BufferedReader file;
	 
	 public GestorClase(){
		 try {
			file = new BufferedReader (new FileReader("markGestor.txt"));
		} catch (FileNotFoundException e) {
			 clase = new Clase(null);
		}finally{
			if(file!=null){
				//leer file
				 clase = new Clase(null);
			 }
		}
		 
		 
	 }
	
	public void gestionarAlumnos() throws IOException{
		int opcion;
		//inicializar keyboard
		do{
			System.out.println ("1.- Introducir clase");
			System.out.println ("2.- Ver Lista");
			System.out.println ("3.- Meter notas");
			System.out.println ("0.- Salir");
			System.out.print("\tSelecciona opción: ");
			opcion = teclado.nextInt();
			switch (opcion){
				case 1: introducirClase(); break;
				case 2: clase.ver(); break;
				case 3: clase.ponerNotas(); break;
				case 0: clase.writeFile();
				default: System.out.println ("opción no valida");
			}
		}while (opcion!=0);
	}

	private void introducirClase() {
		int idal;
		String nombre, apellido;
		Alumno a;
		for ( int i = 0; i<numAlumnos; ){
			System.out.print("Idal: ");
			idal = teclado.nextInt(); teclado.nextLine();
			System.out.print("Nombre: ");
			nombre = teclado.nextLine();
			System.out.print("Apellido: ");
			apellido = teclado.nextLine();
			a = new Alumno (idal,nombre,apellido);
			if (clase.add(a)){
				System.out.println ("Alumno añadido");
				i++;
			}else{
				System.out.println ("Alumnos ya esta en clase");
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		GestorClase programa = new GestorClase();
		programa.gestionarAlumnos();

	}

}
