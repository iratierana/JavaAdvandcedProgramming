import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import anotacion.*; //Improta las anotaciones deifinidas para programación2

/**
 * Pruebas JUnit para Estrella.
 * 
 * @author Raúl García Castro (código original)
 * @author Manuel Collado Machuca (actualizaciones)
 */
public class TestEstrella {

	private static Estrella estrella1 = null; // común para todos los tests

	/** Inicialización común para cada uno de los tests. */
	@Before
	public void setUp() {
		estrella1 = new Estrella("Sol", 23.4, 180);
	}
	
	/**
	 * Prueba que verifica que se han rellenado correctamente los datos de los autores
	 */
	@Test
	public void testDatosAlumno(){
		int ok=0;
		if (Estrella.class.isAnnotationPresent(Programacion2.class))
		{
			//Tiene la anotación con los datos de los autores
			Programacion2 datosAutores = Estrella.class.getAnnotation(Programacion2.class); 
			String nombre1 = datosAutores.nombreAutor1();
			String nombre2 = datosAutores.nombreAutor2();
			String apellido1 = datosAutores.apellidoAutor1();
			String apellido2 = datosAutores.apellidoAutor2();
			String email1 = datosAutores.emailUPMAutor1();
			String email2 = datosAutores.emailUPMAutor2();
			boolean enGrupo = datosAutores.enGrupo();
			if (nombre1.equals("") || apellido1.equals("") || email1.equals(""))
				ok=-2; //Falta algún dato del alumno 1
			if (enGrupo && (nombre2.equals("") || apellido2.equals("") || email2.equals("")))
				ok=-3; //Falta algún dato del alumno 2

			System.out.println("Datos de los autores\n"+
					"------------------------------\n"+
					"Autor1: "+nombre1+","+","+apellido1+","+email1+"\n"+
					((enGrupo)?
							"Autor2: "+nombre2+","+","+apellido2+","+email2+"\n":""));

			//Se comrpueba que esté registrado el alumno
			try {
				bd.ConexionTXT conexion = new bd.ConexionTXT("alumnosprog2Codec.txt");
				if (!conexion.comprobarUsuario(bd.Codificacion.md5Java(email1.toLowerCase())))
				{
					System.err.println ("El email: "+email1+" no está registrado en la asignatura");
					ok=-4; //email no registrado
				}
				if (enGrupo && !conexion.comprobarUsuario(bd.Codificacion.md5Java(email2.toLowerCase())))
				{
					System.err.println ("El email: "+email2+" no está registrado en la asignatura");
					ok=-4; //email no registrado
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		else
			//Se sale por que hay un error al no haber puesto
			ok = -1; //No se ha escrito la anotación

		assertEquals ("Faltan datos de los autores",ok,0);

	}
	// -------------------------------------------------------------------
	/** Prueba constructor (identificador) */
	@Test
	public void testGetIdentificador() {
		assertEquals("\nIdentificador incorrecto:\n", "Sol",
				estrella1.getIdentificador());
	}
	/** Prueba constructor (campo magnético) */
	@Test
	public void testGetCampoMagnetico() {
		assertEquals("\nCampo magnético incorrecto:\n", 23.4,
				estrella1.getCampoMagnetico(), 0.0);
	}
	/** Prueba constructor (índice de color) */
	@Test
	public void testGetIndiceColor() {
		assertEquals("\nIndice de color incorrecto:\n", 180,
				estrella1.getIndiceColor());
	}

	// -------------------------------------------------------------------
	/** Prueba equals: todo diferente */
	@Test
	public void testEquals1() {
		Estrella estrella2 = new Estrella("Alpha Centauri", 26.4, 4280);
		assertFalse("Problemas al comparar dos estrellas:",
				estrella1.equals(estrella2));
	}
	/** Prueba equals: mismo identificador, resto diferente */
	@Test
	public void testEquals2() {
		Estrella estrella2 = new Estrella(new String("Sol"), 21.3, 130);
		assertTrue("Problemas al comparar dos estrellas:",
				estrella1.equals(estrella2));
	}
	/** Prueba equals: distinto identificador, resto igual */
	@Test
	public void testEquals3() {
		Estrella estrella2 = new Estrella("Rigel", 23.4, 180);
		assertFalse("Problemas al comparar dos estrellas:",
				estrella1.equals(estrella2));
	}

	// -------------------------------------------------------------------
	/** Prueba desplazar */
	@Test
	public void testDesplazar() {
		estrella1.desplazar();
		assertEquals("\nCampo magnético incorrecto:\n", 17.9,
				estrella1.getCampoMagnetico(), 0.0);
		assertEquals("\nIndice de color incorrecto:\n", 179,
				estrella1.getIndiceColor());
	}

}
