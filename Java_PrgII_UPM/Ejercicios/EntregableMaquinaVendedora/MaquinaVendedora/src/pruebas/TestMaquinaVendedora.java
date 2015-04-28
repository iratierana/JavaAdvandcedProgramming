package pruebas;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

import maquina.*;
import maquina.excepciones.*;

/**
 * Programa de prueba de la M�quinaVendedora
 * 
 * @author Manuel Collado (c�digo original)
 * @author �ngel Lucas (actualizaci�n)
 * @version Marzo 2014
 */
public class TestMaquinaVendedora {
    private static MaquinaVendedora maquina;
    private static int capacidad;
    private static TipoProducto[] productos;
    private static int[] unidades;
    private static int saldo;

    // Crear la m�quina de prueba, vac�a
    private void crearMaquina() throws ExcepcionCantidadNoValida {
        maquina = new MaquinaVendedora(4, 5);
        capacidad = 5;
        productos = new TipoProducto[]{null, null, null, null};
        unidades = new int[]{0, 0, 0, 0};
        saldo = 0;
        comprobarMaquina();
    }

    // Poner productos en la m�quina de prueba
    private void llenarMaquina() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto {
        maquina.reponer(0, TipoProducto.SANDWICH, 2);
        maquina.reponer(1, TipoProducto.BOMBONES, 3);
        maquina.reponer(3, TipoProducto.BOMBONES, 1);
        productos = new TipoProducto[]{TipoProducto.SANDWICH,
                TipoProducto.BOMBONES, null, TipoProducto.BOMBONES};
        unidades = new int[]{2, 3, 0, 1};
        comprobarMaquina();
    }

    // Comprobar el estado de la m�quina
    private void comprobarMaquina() {
        Deposito[] depositos = getDepositos(maquina);
        int numDep = depositos.length;
        assertEquals("\nN�mero de dep�sitos incorrecto\n", productos.length,
                numDep);
        for (int k = 0; k < numDep; k++) {
            assertEquals("\nCapacidad del dep�sito " + k + " incorrecta\n",
                    capacidad, depositos[k].getCapacidad());
            if (productos[k] != null) {
                assertEquals("\nProducto en dep�sito " + k + " incorrecto\n",
                        productos[k], depositos[k].getProducto());
            }
            assertEquals("\nUnidades en dep�sito " + k + " incorrectas\n",
                    unidades[k], depositos[k].getUnidades());
        }
        Monedero monedero = getMonedero(maquina);
        assertEquals("\nSaldo incorrecto\n", saldo, monedero.getSaldo());
    }

    /**
     * Prueba si se han rellenado correctamente los datos de los autores
     */
    @Test
    public void testDatosAlumno(){
        int ok = anotacion.Autores.probarAutores(MaquinaVendedora.class);
        assertEquals ("Error en datos de autores", ok, 0);
    }

    /**
     * Prueba constructor MaquinaVendedora(int, int)}
     */
    @Test
    // Caso normal
    public void testMaquinaVendedora1() throws ExcepcionCantidadNoValida {
        crearMaquina();
    }
    // Crear m�quina sin dep�sitos
    @Test(expected = ExcepcionCantidadNoValida.class)
    public void testMaquinaVendedora2() throws ExcepcionCantidadNoValida {
        @SuppressWarnings("unused")
        MaquinaVendedora maquina = new MaquinaVendedora(0, 5);
    }
    
    // Crear m�quina con n�mero de dep�sitos negativo
    @Test(expected = ExcepcionCantidadNoValida.class)
    public void testMaquinaVendedora3() throws ExcepcionCantidadNoValida {
        @SuppressWarnings("unused")
        MaquinaVendedora maquina = new MaquinaVendedora(-1, 5);
    }
    // Crear m�quina con dep�sitos de capacidad nula
    @Test(expected = ExcepcionCantidadNoValida.class)
    public void testMaquinaVendedora4() throws ExcepcionCantidadNoValida {
        @SuppressWarnings("unused")
        MaquinaVendedora maquina = new MaquinaVendedora(4, 0);
    }
    // Crear m�quina con dep�sitos de capacidad negativa
    @Test(expected = ExcepcionCantidadNoValida.class)
    public void testMaquinaVendedora5() throws ExcepcionCantidadNoValida {
        @SuppressWarnings("unused")
        MaquinaVendedora maquina = new MaquinaVendedora(4, -1);
    }

    /**
     * Prueba reponer(int, maquina.TipoProducto, int)
     */
    @Test
    // Reponer en dep�sitos vac�os
    public void testReponer1() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto {
        crearMaquina();
        llenarMaquina();
    }
    // Reponer en dep�sito con �ndice < 0
    @Test(expected = ExcepcionDepositoIncorrecto.class)
    public void testReponer2a() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto {
        crearMaquina();
        maquina.reponer(-1, TipoProducto.BIZCOCHO, 1);
    }
    // Reponer en dep�sito con �ndice > �ltimo
    @Test(expected = ExcepcionDepositoIncorrecto.class)
    public void testReponer2b() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto {
        crearMaquina();
        maquina.reponer(4, TipoProducto.BIZCOCHO, 1);
    }
    // Reponer tipo de producto nulo
    @Test(expected = ExcepcionProductoIncorrecto.class)
    public void testReponer3a() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto {
        crearMaquina();
        maquina.reponer(2, null, 1);
    }
    // Reponer producto con precio negativo
    @Test(expected = ExcepcionProductoIncorrecto.class)
    public void testReponer3b() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto {
        crearMaquina();
        maquina.reponer(2, TipoProducto.BASURA, 1);
    }
    // A�adir mismo producto a dep�sito no vac�o
    @Test
    public void testReponer3c() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto {
        crearMaquina();
        llenarMaquina();
        maquina.reponer(3, TipoProducto.BOMBONES, 1);
        unidades[3] += 1;
        comprobarMaquina();
    }
    // A�adir distinto producto a dep�sito no vac�o
    @Test(expected = ExcepcionProductoIncorrecto.class)
    public void testReponer3d() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto {
        crearMaquina();
        llenarMaquina();
        maquina.reponer(3, TipoProducto.BIZCOCHO, 1);
    }
    // Reponer cantidad de producto cero
    @Test(expected = ExcepcionCantidadNoValida.class)
    public void testReponer4a() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto {
        crearMaquina();
        maquina.reponer(2, TipoProducto.BIZCOCHO, 0);
    }
    // Reponer cantidad de producto negativa
    @Test(expected = ExcepcionCantidadNoValida.class)
    public void testReponer4b() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto {
        crearMaquina();
        maquina.reponer(2, TipoProducto.BIZCOCHO, -1);
    }
    @Test
    // Rellenar dep�sito hasta el m�ximo
    public void testReponer4c() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto {
        crearMaquina();
        llenarMaquina();
        maquina.reponer(1, TipoProducto.BOMBONES, 2);
        unidades[1] += 2;
        comprobarMaquina();
    }
    // Poner m�s producto del que cabe
    @Test(expected = ExcepcionCantidadNoValida.class)
    public void testReponer4d() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto {
        crearMaquina();
        llenarMaquina();
        maquina.reponer(1, TipoProducto.BOMBONES, 3);
    }
    // Vaciar dep�sito y reponer producto distinto
    @Test
    public void testReponer4e() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto,
            ExcepcionFaltaProducto, ExcepcionFaltaDinero {
        crearMaquina();
        llenarMaquina();
        maquina.ponerDinero(10);
        saldo += 10;
        comprobarMaquina();
        while (unidades[0] > 0) {
            maquina.comprar(TipoProducto.SANDWICH);
            unidades[0]--;
            saldo -= TipoProducto.SANDWICH.getPrecio();
            comprobarMaquina();
        }
        maquina.reponer(0, TipoProducto.BOMBONES, 4);
        productos[0] = TipoProducto.BOMBONES;
        unidades[0] = 4;
        comprobarMaquina();
    }

    /**
     * Prueba ponerDinero(int)
     */
    // Caso normal
    @Test
    public void testPonerDinero1() throws ExcepcionCantidadNoValida {
        crearMaquina();
        maquina.ponerDinero(7);
        saldo += 7;
        comprobarMaquina();
        maquina.ponerDinero(2);
        saldo += 2;
        comprobarMaquina();
    }
    // Poner cantidad cero
    @Test(expected = ExcepcionCantidadNoValida.class)
    public void testPonerDinero2a() throws ExcepcionCantidadNoValida {
        crearMaquina();
        maquina.ponerDinero(0);
    }
    // Poner cantidad negativa
    @Test(expected = ExcepcionCantidadNoValida.class)
    public void testPonerDinero2b() throws ExcepcionCantidadNoValida {
        crearMaquina();
        maquina.ponerDinero(-1);
    }

    /**
     * Prueba comprar(maquina.TipoProducto)}.
     */
    // Caso normal, producto en un solo dep�sito, sobra dinero
    @Test
    public void testComprar1a() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto,
            ExcepcionFaltaProducto, ExcepcionFaltaDinero {
        crearMaquina();
        llenarMaquina();
        maquina.ponerDinero(10);
        saldo = 10;
        comprobarMaquina();
        maquina.comprar(TipoProducto.SANDWICH);
        unidades[0]--;
        saldo -= TipoProducto.SANDWICH.getPrecio();
        comprobarMaquina();
    }
    // Caso normal, producto en un solo dep�sito, dinero exacto
    @Test
    public void testComprar1b() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto,
            ExcepcionFaltaProducto, ExcepcionFaltaDinero {
        crearMaquina();
        llenarMaquina();
        maquina.ponerDinero(2);
        saldo = 2;
        comprobarMaquina();
        maquina.comprar(TipoProducto.SANDWICH);
        unidades[0]--;
        saldo -= TipoProducto.SANDWICH.getPrecio();
        comprobarMaquina();
    }
    // Caso normal, producto en dos dep�sitos, sirve del primero
    @Test
    public void testComprar1c() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto,
            ExcepcionFaltaProducto, ExcepcionFaltaDinero {
        crearMaquina();
        llenarMaquina();
        maquina.ponerDinero(10);
        saldo += 10;
        comprobarMaquina();
        maquina.comprar(TipoProducto.BOMBONES);
        unidades[1]--;
        saldo -= TipoProducto.BOMBONES.getPrecio();
        comprobarMaquina();
    }
    // Caso normal, producto en dos dep�sitos, agota el primero y sirve del
    // segundo
    @Test
    public void testComprar1d() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto,
            ExcepcionFaltaProducto, ExcepcionFaltaDinero {
        crearMaquina();
        llenarMaquina();
        maquina.ponerDinero(30);
        saldo = 30;
        comprobarMaquina();
        while (unidades[1] > 0) {
            maquina.comprar(TipoProducto.BOMBONES);
            unidades[1]--;
            saldo -= TipoProducto.BOMBONES.getPrecio();
            comprobarMaquina();
        }
        maquina.comprar(TipoProducto.BOMBONES);
        unidades[3]--;
        saldo -= TipoProducto.BOMBONES.getPrecio();
        comprobarMaquina();
    }
    // Comprar producto nulo
    @Test(expected = ExcepcionProductoIncorrecto.class)
    public void testComprar2a() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto,
            ExcepcionFaltaProducto, ExcepcionFaltaDinero {
        crearMaquina();
        maquina.comprar(null);
    }
    // Comprar producto con precio negativo
    @Test(expected = ExcepcionProductoIncorrecto.class)
    public void testComprar2b() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto,
            ExcepcionFaltaProducto, ExcepcionFaltaDinero {
        crearMaquina();
        maquina.comprar(TipoProducto.BASURA);
    }
    // Comprar con dinero insuficiente
    @Test(expected = ExcepcionFaltaDinero.class)
    public void testComprar3a() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto,
            ExcepcionFaltaProducto, ExcepcionFaltaDinero {
        crearMaquina();
        llenarMaquina();
        maquina.ponerDinero(1);
        saldo = 1;
        comprobarMaquina();
        maquina.comprar(TipoProducto.SANDWICH);
    }
    // Comprar sin ning�n dinero
    @Test(expected = ExcepcionFaltaDinero.class)
    public void testComprar3b() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto,
            ExcepcionFaltaProducto, ExcepcionFaltaDinero {
        crearMaquina();
        llenarMaquina();
        maquina.comprar(TipoProducto.SANDWICH);
    }
    // Comprar con m�quina vac�a
    @Test(expected = ExcepcionFaltaProducto.class)
    public void testComprar4a() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto,
            ExcepcionFaltaProducto, ExcepcionFaltaDinero {
        crearMaquina();
        maquina.ponerDinero(10);
        saldo = 10;
        comprobarMaquina();
        maquina.comprar(TipoProducto.SANDWICH);
    }
    // Comprar con s�lo otros productos
    @Test(expected = ExcepcionFaltaProducto.class)
    public void testComprar4b() throws ExcepcionCantidadNoValida,
            ExcepcionDepositoIncorrecto, ExcepcionProductoIncorrecto,
            ExcepcionFaltaProducto, ExcepcionFaltaDinero {
        crearMaquina();
        llenarMaquina();
        maquina.ponerDinero(10);
        saldo = 10;
        comprobarMaquina();
        maquina.comprar(TipoProducto.BIZCOCHO);
    }

    /**
     * Prueba devolver()
     */
    // Caso normal
    @Test
    public void testDevolver1() throws ExcepcionCantidadNoValida,
            ExcepcionFaltaDinero {
        crearMaquina();
        maquina.ponerDinero(4);
        saldo = 4;
        comprobarMaquina();
        maquina.devolver();
        saldo = 0;
        comprobarMaquina();
    }
    // Devolver saldo cero
    @Test(expected = ExcepcionFaltaDinero.class)
    public void testDevolver2() throws ExcepcionCantidadNoValida,
            ExcepcionFaltaDinero {
        crearMaquina();
        maquina.devolver();
    }
    
    
    
 //Se saca la inf de los atributos privados   
    private Deposito[] getDepositos(MaquinaVendedora instancia) {
    	Class<?> secretClass = instancia.getClass();
        // Print all the field names & values
        Field field;
        Deposito[] deposito=null;
		try {
			field = secretClass.getDeclaredField("deposito");
			field.setAccessible(true);
			deposito = (Deposito[])field.get(instancia);
			field.setAccessible(false);
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return deposito;
    }
    
    private Monedero getMonedero(MaquinaVendedora instancia) {
    	Monedero monedero = null;
    	Class<?> secretClass = instancia.getClass();
        // Print all the field names & values
        Field field;
        
		try {
			field = secretClass.getDeclaredField("monedero");
			field.setAccessible(true);
			monedero = (Monedero)field.get(instancia);
			field.setAccessible(false);
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return monedero;
    }

}
