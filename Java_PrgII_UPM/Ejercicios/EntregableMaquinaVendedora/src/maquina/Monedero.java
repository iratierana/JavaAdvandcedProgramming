package maquina;
import maquina.excepciones.*;

/**
 * Aceptador de dinero en la máquina de venta automática
 * 
 * @author Manuel Collado
 * @version Octubre 2013
 *
 * @opt nodefillcolor "lightblue"
 */
public class Monedero {
    private int saldo; // Importe neto disponible

    // Constructor
    public Monedero() {
        saldo = 0;
    }

    // Getter
    public int getSaldo() {
        return saldo;
    }

    /**
     * Poner dinero en el monedero
     * 
     * @throws ExcepcionCantidadNoValida
     *         si el importe no es mayor que cero
     */
    public void poner(int cantidad) throws ExcepcionCantidadNoValida {
        if (cantidad <= 0) {
            throw new ExcepcionCantidadNoValida("Importe " + cantidad + " <= 0");
        }
        saldo = saldo + cantidad;
    }

    /**
     * Cobrar la cantidad indicada, descontándola del saldo
     * 
     * @throws ExcepcionCantidadNoValida
     *         si el importe no es mayor que cero
     * @throws ExcepcionFaltaDinero
     *         si el saldo es menor que la cantidad a cobrar
     */
    public void cobrar(int cantidad) throws ExcepcionFaltaDinero,
            ExcepcionCantidadNoValida {
        if (cantidad <= 0) {
            throw new ExcepcionCantidadNoValida("A cobrar " + cantidad
                    + " <= 0");
        } else if (cantidad > saldo) {
            throw new ExcepcionFaltaDinero("A cobrar " + cantidad + ", saldo "
                    + saldo);
        }
        saldo = saldo - cantidad;
    }

    /**
     * Devolver el saldo, dejando el monedero vacío
     * 
     * @throws ExcepcionFaltaDinero
     *         si no hay nada que devolver
     */
    public void devolver() throws ExcepcionFaltaDinero {
        if (saldo <= 0) {
            throw new ExcepcionFaltaDinero("No hay nada que devolver");
        }
        saldo = 0;
    }
}
