package fileStudentsMark;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;


public class Clase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6198993411623808936L;
	ArrayList<Alumno> studentList;
	ListIterator studentListIt;
	int numAlumnos;
	
	public Clase (ArrayList arrayList){
		if(arrayList==null){
			studentList = arrayList;
		}
		else{
			studentList = new ArrayList<Alumno>();
		}
	}
	
	public boolean add(Alumno a){
		
		if (isInList(a) == false){
			studentList.add(a);
			return true;
		}
		return false;
	}
	public void ver(){
		studentListIt = studentList.listIterator();
		
		while(studentListIt.hasNext()){
			studentListIt.next().toString();
		}
		return;
	}
	
	public void ponerNotas(){
		Scanner teclado = new Scanner(System.in);
		for (Alumno a: studentList){
			float nota;
			System.out.println (a);
			System.out.println();
			System.out.print ("Nota del alumno?: ");
			nota = teclado.nextFloat();
			a.setNota(nota);
		}
	}
	public boolean ponerNota(Alumno a){
		a.setNota(0);
		return true;
		
	}
	private boolean isInList(Alumno student){
		studentListIt = studentList.listIterator();
		
		while(studentListIt.hasNext()){
			if(studentListIt.next().equals(student)){
				return false;
			}
		}
		return true;
	}
	
	void writeFile() throws IOException {
		BufferedWriter destinationFile = new BufferedWriter(new FileWriter("markGestor.txt"));
		studentListIt = studentList.listIterator();
		
		

		try {
			while(studentListIt.hasNext()){
				destinationFile.write(studentListIt.next().toString());
			}						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(destinationFile != null){
				try {
					destinationFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
