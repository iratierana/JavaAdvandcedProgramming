package pilaContador;
import pilas.Pila;
import anotacion.Programacion2;
import pilas.ExcepcionPilaVacia;

@Programacion2 (
		)


public class PilaConContador<Informacion> extends Pila<Informacion> {

	/**
	 * Atributo contador que indica el numero de elementos que estan apilados actualmente
	 */
	private int noElementosActuales;

	/**
	 * Constructor de la clase PilaConContador. Crea la pila e inicializa a 0 el atributo noElementosActuales
	 */
	public PilaConContador () {
		super();
	}

	/**
	 * Metodo que inserta un elemento del tipo de datos de la pila en la cima de la pila
	 */
	public void apilar (Informacion elemento) {
		super.apilar(elemento);
		noElementosActuales++;
	}

	/**
	 * Metodo que elimina el ultimo elemento apilado
	 * PRE1 : La pila no debe estar vacia
	 * @throws ExcepcionPilaVacia si se viola PRE1
	 */
	public void desapilar () throws ExcepcionPilaVacia{
		super.desapilar();
		noElementosActuales--;
	}

	/**
	 * Metodo que extrae la cima de la pila, y la devuelve
	 * NOTA: No se decrementa el atributo noElementosActuales ya que sacarCima llama a desapilar, que efectua dicho decremento.
	 * PRE1: La pila no debe estar vacia
	 * @throws ExcepcionPilaVacia si se viola PRE1
	 */
	public Informacion sacarCima () throws ExcepcionPilaVacia {
		return super.sacarCima();
	}

	/**
	 * Metodo que vacia completamente la pila y pone a 0 el numero de elementos apilados.
	 */
	public void vaciar () {
		super.vaciar();
		noElementosActuales = 0;
	}

	/**
	 * Metodo que muestra el numero de elementos apilados actualmente
	 * @return noElementosActuales ,es decir, numero de elementos apilados actualmente
	 */
	public int getNumeroElementos () {
		return this.noElementosActuales;
	}
}

