package pruebas;
import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

import pilas.ExcepcionPilaVacia;
import pilas.Pila;
import pilaContador.PilaConContador;
;

/**
 * Programa de prueba de la Pila con Contador
 * 
 * @author Manuel Collado (revisión del código)
 * @version Noviembre 2013
 */
public class TestPilaConContador {
    private PilaConContador<Integer> pila;

 

    /**
     * Se encarga de inicializar las pruebas
     */
    @Before
    public void setup() {
        pila = new PilaConContador<Integer>();
    }

    /**
     * Prueba si se han rellenado correctamente los datos de los autores
     */
    @Test
    public void testDatosAlumno(){
        int ok = anotacion.Autores.probarAutores(PilaConContador.class);
        assertEquals ("Error en datos de autores", ok, 0);
    }

    /**
     * Prueba si PilaConContador es una especialización de Pila
     */
    @Test
    public void testExtiende() {
        assertTrue("Implementación incorrecta de PilaConContador",
                this.pila instanceof Pila<?>);
    }

    /**
     * Prueba el constructor de pila vacía
     */
    @Test
    public void testNuevaPila() {
        assertEquals("Contador inicial incorrecto", 0,
                pila.getNumeroElementos());
    }

    /**
     * Prueba apilar datos 1 a 100
     */
    @Test
    public void testApilar() throws ExcepcionPilaVacia {
        meterNEnteros(this.pila, 100);
        assertEquals("Valor en la cima incorrecto", (Integer) 100,
                pila.getCima());
        assertEquals("Número de elementos incorrecto", 100,
                pila.getNumeroElementos());
    }

    /**
     * Prueba desapilar en pila vacía
     */
    @Test
    public void testDesapilar0() throws ExcepcionPilaVacia {
        try {
            pila.desapilar();
            fail("No se lanza excepción al desapilar en una pila vacía");
        } catch (ExcepcionPilaVacia e) {
            // se captura la excepción y se continúa la prueba
        }
        assertEquals(
                "Número de elementos incorrecto tras desapilar en una pila vacía",
                0, pila.getNumeroElementos());
    }

    /**
     * Prueba desapilar.
     * Apila unaa serie de números y se van desapilando y comprobando el contador
     */
    @Test
    public void testDesapilar() throws ExcepcionPilaVacia {
        meterNEnteros(this.pila, 77);

        // Tenemos una pila con 77 elementos
        for (int i = 77; i > 0; i--) {
            int cuenta = pila.getNumeroElementos();
            pila.desapilar();
            assertEquals("Contador de pila mal decrementado", cuenta - 1,
                    pila.getNumeroElementos());
        }

        // La pila debe quedar vacía
        assertEquals("Número de elementos incorrecto", 0,
                pila.getNumeroElementos());
    }

    /**
     * Prueba vaciar. Se mete en la pila una serie de datos, se vacía se verifica que el contador sea correcto
     */
    @Test
    public void testVaciar() {
        meterNEnteros(this.pila, 98);
        pila.vaciar();
        assertEquals("Número de elementos incorrecto tras vaciar la pila", 0,
                pila.getNumeroElementos());
    }

    /**
     * Prueba sacarCima de una pila vacía
     */
    @Test
    public void testSacarCima0() throws ExcepcionPilaVacia {
        try {
            @SuppressWarnings("unused")
            Integer cima = pila.sacarCima();
            fail("No se lanza excepción al sacar la cima de una pila vacía");
        } catch (ExcepcionPilaVacia e) {
            // se captura la excepción y se continúa la prueba
        }
        assertEquals(
                "Número de elementos incorrecto tras sacar la cima de una pila vacía",
                0, pila.getNumeroElementos());
    }

    /**
     * Prueba sacarCima
     * Apila una serie de números y luego se va sacando la cima y comprobando el contador
     */
    @Test
    public void testSacarCima() throws ExcepcionPilaVacia {
        meterNEnteros(this.pila, 85);

        // Tenemos una pila con 85 elementos
        for (int i = 85; i > 0; i--) {
            int cuenta = pila.getNumeroElementos();
            Integer cima = pila.sacarCima();
            assertEquals("Contador de pila mal decrementado", cuenta - 1,
                    pila.getNumeroElementos());
            assertTrue("La pila no alamacena bien los datos", cima.equals(i));
        }

        // La pila debe quedar vacía
        assertEquals("Número de elementos incorrecto", 0,
                pila.getNumeroElementos());
    }
    
    
	/**
	 * Método que comrpueba que se haya definido un contador
	 */
	@Test
	public void testAtributosNecesarios(){
	 assertTrue ("Error: hace falta un contador para llevar la cuenta de los elementos de la pila",
			 this.atributoEntero(pila));	
	}
	
	//Auxiliar
			/**
			 * Método que comprueba si se ha definido algún contador
			 * @return
			 */
		    private boolean atributoEntero(PilaConContador<?> instancia) {//atributoEntero
		    	boolean encontrado = false;
		    	Class<?> secretClass =PilaConContador.class;
		        Field campos[];
				try {
					campos = secretClass.getDeclaredFields(); //Se optinene todos los atributos
					for (int i=0;!encontrado && i<campos.length;i++){//For
						Class<?> clase = campos[i].getType();
						encontrado = clase.equals(Integer.class); //Se puede usar Integer
						encontrado= encontrado || campos[i].getType().getName()=="int"; //O se puede usar int
					}//For
				} catch ( SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return encontrado;
		    }//atributoEntero
		    
		    // Apilar cierta cantidad de elementos
		    private static void meterNEnteros(PilaConContador<Integer> pila, int numero) {
		        for (int i = 1; i <= numero; i++) {
		            int cuenta = pila.getNumeroElementos();
		            pila.apilar(i);
		            assertEquals("Contador de pila mal incrementado", cuenta + 1,
		                    pila.getNumeroElementos());
		        }
		    }
}
