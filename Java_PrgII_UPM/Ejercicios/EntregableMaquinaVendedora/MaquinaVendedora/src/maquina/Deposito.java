package maquina;
import maquina.excepciones.*;

/**
 * Dep�sito de producto en la m�quina de venta autom�tica
 * 
 * @author Manuel Collado
 * @version Octubre 2013
 * 
 * @opt nodefillcolor "lightblue"
 */
public class Deposito {
    private int capacidad; // Capacidad del dep�sito
    private TipoProducto producto; // Tipo de producto en el dep�sito
    private int unidades; // N�mero actual de unidades del producto

    // Constructor
    public Deposito(int capacidad) throws ExcepcionCantidadNoValida {
        if (capacidad <= 0) {
            throw new ExcepcionCantidadNoValida("Capacidad " + capacidad
                    + " <= 0");
        }
        this.capacidad = capacidad;
        producto = null;
        unidades = 0;
    }

    // Getters
    public int getCapacidad() {
        return capacidad;
    }
    public TipoProducto getProducto() {
        return producto;
    }
    public int getUnidades() {
        return unidades;
    }

    /**
     * Reponer producto en el dep�sito
     * 
     * @throws ExcepcionProductoIncorrecto
     *         si el tipo de producto es un valor nulo, o si el dep�sito ya
     *         contiene otro producto diferente
     * @throws ExcepcionCantidadNoValida
     *         si la cantidad es cero o negativa o es mayor que el espacio libre
     *         en el dep�sito
     */
    public void reponer(TipoProducto producto, int cantidad)
            throws ExcepcionProductoIncorrecto, ExcepcionCantidadNoValida {
        if (producto == null) {
            throw new ExcepcionProductoIncorrecto("Producto nulo");
        } else if (this.unidades > 0 && !producto.equals(this.producto)) {
            throw new ExcepcionProductoIncorrecto(
                    "Producto distinto del actual");
        } else if (cantidad <= 0) {
            throw new ExcepcionCantidadNoValida("Cantidad " + cantidad
                    + " <= 0");
        } else if (unidades + cantidad > capacidad) {
            throw new ExcepcionCantidadNoValida("No caben " + cantidad
                    + " unidades");
        }
        this.producto = producto;
        unidades = unidades + cantidad;
    }
    /**
     * Servir una unidad de producto
     * 
     * @throws ExcepcionFaltaProducto
     *         si el dep�sito est� vac�o
     */
    public void servir() throws ExcepcionFaltaProducto {
        if (unidades <= 0) {
            throw new ExcepcionFaltaProducto("Dep�sito vac�o");
        }
        unidades--;
    }
}
