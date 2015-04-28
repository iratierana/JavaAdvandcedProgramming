
import anotacion.*; //Importa las anotaciones definidas para programación2
@Programacion2 (
		
		)
public class Estrella {
	
	private String identificador;
	private double campoMagnetico;
	private int indiceColor;
	
	Estrella (String identificador, double campoMagnetico, int indiceColor) {
		this.identificador = identificador;
		this.campoMagnetico = campoMagnetico;
		this.indiceColor = indiceColor;
	}

	/**
	 * @return el identificador de la estrella
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * @return el campo Magnetico de la estrella
	 */
	public double getCampoMagnetico() {
		return campoMagnetico;
	}

	/**
	 * @return el indice de Color de la estrella
	 */
	public int getIndiceColor() {
		return indiceColor;
	}
	
	public void desplazar() {
		this.campoMagnetico = this.campoMagnetico - 5.5;
		this.indiceColor = this.indiceColor -1;
	}
	
	public boolean equals (Estrella star) {
		return this.identificador.equals(star.identificador);
	}
	
	
	
	

	//TODO

}
