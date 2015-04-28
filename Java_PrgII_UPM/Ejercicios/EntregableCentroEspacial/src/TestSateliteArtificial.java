import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import anotacion.Programacion2;

/**
 * Pruebas JUnit para SateliteArtificial.
 * 
 * @author Raúl García Castro (código original)
 * @author Manuel Collado Machuca (actualizaciones)
 */
public class TestSateliteArtificial {

	/** La constante del factor del índice de color. */
	private static final double FACTOR_INDICE = 2.1;
	/** La constante para el límite del campo magnético. */
	private static final double LIMITE = 1000.0;
	/** El satélite que se utiliza en los tests. */
	private SateliteArtificial satelite1 = null;
	/** La estrella que se utiliza en los tests. */
	private Estrella estrella1 = null;

	/** Inicialización común para cada uno de los tests. */
	@Before
	public void setUp() {
		estrella1 = new Estrella("Sol", 23.4, 180);
		satelite1 = new SateliteArtificial(estrella1);
	}
	
	/**
	 * Prueba que verifica que se han rellenado correctamente los datos de los autores
	 */
	@Test
	public void testDatosAlumno(){
		int ok=0;
		if (SateliteArtificial.class.isAnnotationPresent(Programacion2.class))
		{
			//Tiene la anotación con los datos de los autores
			Programacion2 datosAutores = SateliteArtificial.class.getAnnotation(Programacion2.class); 
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
	public void testGetIdentificador1() {
		String idActual = satelite1.getIdentificador().substring(3);
		int idNuevo = Integer.parseInt(idActual) + 1;
		SateliteArtificial satelite2 = new SateliteArtificial(estrella1);
		assertEquals("\nIdentificador mal generado:\n", "Sat" + idNuevo,
				satelite2.getIdentificador());
	}
	@Test
	public void testGetIdentificador2() {
		int idActual = Integer.parseInt(satelite1.getIdentificador().substring(
				3));
		for (int i = 0; i < 10; i++) {
			SateliteArtificial satelite2 = new SateliteArtificial(estrella1);
			assertEquals("\nIdentificador mal generado:\n", "Sat"
					+ (idActual + i + 1), satelite2.getIdentificador());
		}
	}
	/** Prueba constructor (estrella) */
	@Test
	public void testGetEstrella() {
		assertEquals("\nEstrella incorrecta:\n", estrella1,
				satelite1.getEstrella());
	}

	// -------------------------------------------------------------------
	/** Prueba cambiar de estrella */
	@Test
	public void testSetEstrella() {
		Estrella estrella2 = new Estrella("Alpha Centauri", 26.4, 4280);
		satelite1.setEstrella(estrella2);
		assertEquals("\nFallo al cambiar la estrella:\n", estrella2,
				satelite1.getEstrella());
	}

	// -------------------------------------------------------------------
	/** Prueba obtener la temperatura de la estrella */
	@Test
	public void testDarTemperatura() {
		assertEquals("\nTemperatura incorrecta:\n", 180 * FACTOR_INDICE,
				satelite1.darTemperatura(), 0.0);
	}

	// -------------------------------------------------------------------
	/** Prueba si hay alerta de tormenta magnética */
	@Test
	public void testHayAlertaTormentaMagnetica1() {
		assertEquals("\nDetección de alerta magnética incorrecta:\n",
				false, satelite1.hayAlertaTormentaMagnetica());
	}
	@Test
	public void testHayAlertaTormentaMagnetica2() {
		Estrella estrella2 = new Estrella("Alpha Centauri", LIMITE+1, 4280);
		SateliteArtificial satelite2 = new SateliteArtificial(estrella2);
		assertEquals("\nDetección de alerta magnética incorrecta:\n",
				true, satelite2.hayAlertaTormentaMagnetica());
	}
	@Test
	public void testHayAlertaTormentaMagnetica3() {
		Estrella estrella2 = new Estrella("Alpha Centauri", LIMITE, 23);
		SateliteArtificial satelite2 = new SateliteArtificial(estrella2);
		assertEquals("\nDetección de alerta magnética incorrecta:\n",
				true, satelite2.hayAlertaTormentaMagnetica());
	}

	// -------------------------------------------------------------------
	/** Prueba equals, estrellas iguales */
	@Test
	public void testEquals1() {
		Estrella estrella2 = new Estrella("Sol", 23.4, 180);
		SateliteArtificial satelite2 = new SateliteArtificial(estrella2);
		assertTrue("\nFalla equals con estrellas iguales:\n",
				satelite1.equals(satelite2));
	}
	/** Prueba equals, estrellas distintas */
	@Test
	public void testEquals2() {
		Estrella estrella2 = new Estrella("Rigel", 23.4, 180);
		SateliteArtificial satelite2 = new SateliteArtificial(estrella2);
		assertFalse("\nFalla equals con estrellas distintas:\n",
				satelite1.equals(satelite2));
	}
	/** Prueba equals, estrellas iguales */
	@Test
	public void testEquals3() {
		Estrella estrella2 = new Estrella("Sol", 23.4, 190);
		SateliteArtificial satelite2 = new SateliteArtificial(estrella2);
		assertTrue("\nFalla equals con estrellas iguales:\n",
				satelite1.equals(satelite2));
	}

}
