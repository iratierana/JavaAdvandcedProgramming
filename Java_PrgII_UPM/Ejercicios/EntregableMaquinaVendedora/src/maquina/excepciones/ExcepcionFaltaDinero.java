package maquina.excepciones;
@SuppressWarnings("serial")
public class ExcepcionFaltaDinero extends Exception {

    public ExcepcionFaltaDinero(String mensaje) {
        super(mensaje);
    }

}
