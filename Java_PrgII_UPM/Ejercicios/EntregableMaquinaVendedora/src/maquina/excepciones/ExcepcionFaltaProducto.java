package maquina.excepciones;
@SuppressWarnings("serial")
public class ExcepcionFaltaProducto extends Exception {

    public ExcepcionFaltaProducto(String mensaje) {
        super(mensaje);
    }

}
