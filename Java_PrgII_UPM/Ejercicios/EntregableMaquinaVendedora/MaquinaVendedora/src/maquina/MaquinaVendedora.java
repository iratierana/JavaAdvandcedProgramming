package maquina;

import maquina.excepciones.*;
import anotacion.Programacion2;

// Rellenar siempre los datos del Autor 1
// Para entrega individual poner enGrupo = false
// Para entrega en grupo rellenar los datos del Autor 2
@Programacion2 (
    nombreAutor1 = "nombre",
    apellidoAutor1 = "apellido1 apellido2",
    emailUPMAutor1 = "usr@alumnos.upm.es",
    enGrupo = true,
    nombreAutor2 = "",
    apellidoAutor2 = "", 
    emailUPMAutor2 = ""
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

        // TODO

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

        // TODO

    }

    /**
     * Insertar billete o moneda en el monedero
     * 
     * @throws ExcepcionCantidadNoValida
     *         si el importe que se inserta es cero o negativo
     */
    public void ponerDinero(int cantidad) throws ExcepcionCantidadNoValida {
        
        // TODO

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
            ExcepcionFaltaDinero {

        // TODO

        }

    /**
     * Devolver el saldo del monedero, dejándolo vacío
     * 
     * @throws ExcepcionFaltaDinero
     *         si el monedero ya estaba vacío
     */
    public void devolver() throws ExcepcionFaltaDinero {

        // TODO

    }
}
