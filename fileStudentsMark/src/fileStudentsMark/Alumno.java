package fileStudentsMark;

import java.io.Serializable;

 
public class Alumno implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7939785817208052648L;
	private int idal;
	private String nombre;
	private String apellido;
	private float calificacion;
	
	public Alumno(int idal, String nombre, String apellido){
		this.idal = idal;
		this.nombre = nombre;
		this.apellido = apellido;
		this.calificacion = 0.0f;
	}

	public float getNota() {
		return calificacion;
	}

	public void setNota(float nota) {
		this.calificacion = nota;
	}

	public int getIdal() {
		return idal;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
	public String toString(){
		String sAlumno;
		sAlumno = "Idal: "+this.idal+ "\n" +
				"Nombre: "+ this.nombre+ "\n" +
				"Apellido: "+ this.apellido+ "\n" +
				"Nota: "+ this.calificacion ;
		return sAlumno;
	}
	public boolean equals (Object o){
		boolean resultado= false;
		Alumno a;
		if (o instanceof Alumno){
			a = (Alumno )o;
			resultado = (this.idal == a.idal);
		}
		return resultado;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
