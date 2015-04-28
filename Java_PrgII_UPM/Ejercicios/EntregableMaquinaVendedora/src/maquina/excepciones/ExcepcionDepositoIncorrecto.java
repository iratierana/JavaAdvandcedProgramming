package maquina.excepciones;
@SuppressWarnings("serial")
public class ExcepcionDepositoIncorrecto extends Exception {

    public ExcepcionDepositoIncorrecto(String mensaje) {
        super(mensaje);
    }

}
