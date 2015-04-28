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
 * M�quina de venta autom�tica
 */
public class MaquinaVendedora {
    private Deposito[] deposito; // Array de dep�sitos individuales
    private Monedero monedero; // Aceptador de dinero

    /**
     * Constructor: inicializa la m�quina vac�a con las capacidades indicadas
     * 
     * @throws ExcepcionCantidadNoValida
     *         si el n�mero de dep�sitos o la capacidad de los dep�sitos no es
     *         mayor que cero
     */
    public MaquinaVendedora(int numDepositos, int capacidad)
            throws ExcepcionCantidadNoValida {

        // TODO

    }

    /**
     * Reponer producto en el dep�sito indicado
     * 
     * @throws ExcepcionDepositoIncorrecto
     *         si la posici�n indicada es un valor fuera de rango
     * @throws ExcepcionProductoIncorrecto
     *         si el tipo de producto es un valor nulo, o si el dep�sito ya
     *         contiene otro producto diferente
     * @throws ExcepcionCantidadNoValida
     *         si la cantidad es cero o negativa o es mayor que el espacio libre
     *         en el dep�sito
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
     * Suministrar una unidad del producto del primer dep�sito que contenga ese
     * producto, y descontar el importe del monedero
     * 
     * @throws ExcepcionProductoIncorrecto
     *         si el tipo de producto es nulo o el precio unitario es cero o
     *         negativo
     * @throws ExcepcionFaltaDinero
     *         si el saldo en el monedero es menor que el precio del producto
     * @throws ExcepcionFaltaProducto
     *         si no hay ning�n dep�sito con existencias de ese producto
     * @throws ExcepcionCantidadNoValida
     *         si el precio del producto es
     */
    public void comprar(TipoProducto producto)
            throws ExcepcionProductoIncorrecto, ExcepcionFaltaProducto,
            ExcepcionFaltaDinero {

        // TODO

        }

    /**
     * Devolver el saldo del monedero, dej�ndolo vac�o
     * 
     * @throws ExcepcionFaltaDinero
     *         si el monedero ya estaba vac�o
     */
    public void devolver() throws ExcepcionFaltaDinero {

        // TODO

    }
}
