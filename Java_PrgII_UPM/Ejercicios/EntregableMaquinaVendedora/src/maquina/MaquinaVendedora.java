package maquina;

import maquina.excepciones.*;
import anotacion.Programacion2;
import maquina.Deposito;
import maquina.Monedero;

// Rellenar siempre los datos del Autor 1
// Para entrega individual poner enGrupo = false
// Para entrega en grupo rellenar los datos del Autor 2
@Programacion2 (
)

/**
 * Máquina de venta automática
 */
public class MaquinaVendedora {
    private Deposito[] deposito; // Array de depósitos individuales
    private Monedero monedero; // Aceptador de dinero

    /**
     * Constructor: inicializa la máquina vacía con las capacidades indicadas
     * 
     * @throws ExcepcionCantidadNoValida
     *         si el número de depósitos o la capacidad de los depósitos no es
     *         mayor que cero
     */
    public MaquinaVendedora(int numDepositos, int capacidad)
            throws ExcepcionCantidadNoValida {
    	if (numDepositos <= 0 || capacidad <= 0)
    		throw new ExcepcionCantidadNoValida("El numero de depositos y la capacidad deben ser mayores que 0");
    	
    	this.deposito = new Deposito [numDepositos];
    	this.monedero = new Monedero ();
    	
    	for (int i = 0; i < this.deposito.length; i++) {
    		this.deposito[i] = new Deposito (capacidad);
    	}
    	


    }
    

    /**
     * Reponer producto en el depósito indicado
     * 
     * @throws ExcepcionDepositoIncorrecto
     *         si la posición indicada es un valor fuera de rango
     * @throws ExcepcionProductoIncorrecto
     *         si el tipo de producto es un valor nulo, o si el depósito ya
     *         contiene otro producto diferente
     * @throws ExcepcionCantidadNoValida
     *         si la cantidad es cero o negativa o es mayor que el espacio libre
     *         en el depósito
     */
    public void reponer(int posicion, TipoProducto producto, int cantidad)
            throws ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto,
            ExcepcionCantidadNoValida {
    	if (posicion >= deposito.length  || posicion < 0) {
    		throw new ExcepcionDepositoIncorrecto ("NO SE ENCUENTRA EL DEPOSITO SELECCIONADO");
    	} 
    	if (producto == null || producto.getPrecio() < 0) {
    			throw new ExcepcionProductoIncorrecto ("ERROR");
    		} 
    	if (cantidad <= 0 || cantidad > deposito [posicion].getCapacidad() - deposito [posicion].getUnidades()) {
    			throw new ExcepcionCantidadNoValida("CANTIDAD ERRONEA O QUE SUPERA LA CAPACIDAD MAXIMA");
    		}
    	
    	deposito [posicion].reponer(producto, cantidad);
    }

    /**
     * Insertar billete o moneda en el monedero
     * 
     * @throws ExcepcionCantidadNoValida
     *         si el importe que se inserta es cero o negativo
     */
    public void ponerDinero(int cantidad) throws ExcepcionCantidadNoValida {
    	
       monedero.poner(cantidad);

    }

    /**
     * Suministrar una unidad del producto del primer depósito que contenga ese
     * producto, y descontar el importe del monedero
     * 
     * @throws ExcepcionProductoIncorrecto
     *         si el tipo de producto es nulo o el precio unitario es cero o
     *         negativo
     * @throws ExcepcionFaltaDinero
     *         si el saldo en el monedero es menor que el precio del producto
     * @throws ExcepcionFaltaProducto
     *         si no hay ningún depósito con existencias de ese producto
     * @throws ExcepcionCantidadNoValida
     *         si el precio del producto es
     */
    public void comprar(TipoProducto producto)
            throws ExcepcionProductoIncorrecto, ExcepcionFaltaProducto,
            ExcepcionFaltaDinero, ExcepcionCantidadNoValida {
    	
    	if (producto == null || producto.getPrecio() < 0 )
    		throw new ExcepcionProductoIncorrecto ("ERROR EN EL PRODUCTO SELECCIONADO");
    	if (producto.getPrecio() > this.monedero.getSaldo())
    		throw new ExcepcionFaltaDinero("NO SE DISPONE DE SUFICIENTE DINERO");
    	else {
    	
    		boolean hayDepositoConProducto = false;
    		int i = 0;
    		while (i < this.deposito.length && !hayDepositoConProducto) {
    			if (this.deposito[i].getProducto() == producto && this.deposito[i].getUnidades() > 0) {
    				deposito [i].servir();
    				monedero.cobrar(producto.getPrecio());
    				hayDepositoConProducto = true;
    			}
    			i++;
    		}
    		
    		if (!hayDepositoConProducto) //Si no hay productos, se devuelve la excepcion
    			throw new ExcepcionFaltaProducto("");
    	}   	
    }

    /**
     * Devolver el saldo del monedero, dejándolo vacío
     * 
     * @throws ExcepcionFaltaDinero
     *         si el monedero ya estaba vacío
     */
    public void devolver() throws ExcepcionFaltaDinero {
   
    	monedero.devolver();
    }
}
