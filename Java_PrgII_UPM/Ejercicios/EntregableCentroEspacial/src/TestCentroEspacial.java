import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import anotacion.Programacion2;

/**
 * Pruebas JUnit para CentroEspacial.
 * 
 * @author Raúl García Castro (código original)
 * @author Manuel Collado Machuca (actualizaciones)
 */
public class TestCentroEspacial {

	private CentroEspacial centroEspacial1 = null; // común para todos los tests

	/**
	 * Inicialización en cada test.
	 */
	@Before
	public void setUp() {
		// Se crean los 5 satélites que va a supervisar el centro espacial.
		// Todos son distintos (monitorizan distintas estrellas)
		SateliteArtificial[] satelites = new SateliteArtificial[5];
		satelites[0] = new SateliteArtificial(new Estrella("Sol", 23.3, 19));
		satelites[1] = new SateliteArtificial(new Estrella("Rigel", 3.3, 319));
		satelites[2] = new SateliteArtificial(new Estrella("Epsilon Indi",
				213.3, 22));
		satelites[3] = new SateliteArtificial(new Estrella("Alpha Centauri",
				111111.1, 35));
		satelites[4] = new SateliteArtificial(
				new Estrella("Altair", 222.3, 249));
		centroEspacial1 = new CentroEspacial("Cabo canaveral", satelites);
	}

	// -------------------------------------------------------------------
	/**
	 * Prueba que verifica que se han rellenado correctamente los datos de los
	 * autores
	 */
	@Test
	public void testDatosAlumno() {
		int ok = 0;
		if (CentroEspacial.class.isAnnotationPresent(Programacion2.class)) {
			// Tiene la anotación con los datos de los autores
			Programacion2 datosAutores = CentroEspacial.class
					.getAnnotation(Programacion2.class);
			String nombre1 = datosAutores.nombreAutor1();
			String nombre2 = datosAutores.nombreAutor2();
			String apellido1 = datosAutores.apellidoAutor1();
			String apellido2 = datosAutores.apellidoAutor2();
			String email1 = datosAutores.emailUPMAutor1();
			String email2 = datosAutores.emailUPMAutor2();
			boolean enGrupo = datosAutores.enGrupo();
			if (nombre1.equals("") || apellido1.equals("") || email1.equals(""))
				ok = -2; // Falta algún dato del alumno 1
			if (enGrupo
					&& (nombre2.equals("") || apellido2.equals("") || email2
							.equals("")))
				ok = -3; // Falta algún dato del alumno 2

			System.out.println("Datos de los autores\n"
					+ "------------------------------\n"
					+ "Autor1: "
					+ nombre1
					+ ","
					+ ","
					+ apellido1
					+ ","
					+ email1
					+ "\n"
					+ ((enGrupo) ? "Autor2: " + nombre2 + "," + "," + apellido2
							+ "," + email2 + "\n" : ""));

			// Se comrpueba que esté registrado el alumno
			try {
				bd.ConexionTXT conexion = new bd.ConexionTXT(
						"alumnosprog2Codec.txt");
				if (!conexion.comprobarUsuario(bd.Codificacion.md5Java(email1
						.toLowerCase()))) {
					System.err.println("El email: " + email1
							+ " no está registrado en la asignatura");
					ok = -4; // email no registrado
				}
				if (enGrupo
						&& !conexion.comprobarUsuario(bd.Codificacion
								.md5Java(email2.toLowerCase()))) {
					System.err.println("El email: " + email2
							+ " no está registrado en la asignatura");
					ok = -4; // email no registrado
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else
			// Se sale por que hay un error al no haber puesto
			ok = -1; // No se ha escrito la anotación

		assertEquals("Faltan datos de los autores", ok, 0);

	}

	// -------------------------------------------------------------------
	/** Prueba constructor (identificador) */
	@Test
	public void testGetIdentificador() {
		assertEquals("Problemas al inicializar el centro espacial:",
				"Cabo canaveral", centroEspacial1.getIdentificador());
	}

	// -------------------------------------------------------------------
	/** Prueba obtener la información de las estrellas */
	@Test
	public void testInformacionEstrellas() {
		String esperado = "Sol (39.9)\nRigel (669.9)\nEpsilon Indi (46.2)\nAlpha Centauri (73.5) ALERTA!\nAltair (522.9)\n";
		assertEquals("\nInformación de estrellas incorrecta:\n", esperado,
				centroEspacial1.informacionEstrellas());
	}

	// -------------------------------------------------------------------
	/** Prueba comprobar satélites (configuración correcta) */
	@Test
	public void testComprobarSatelites1() {
		assertEquals("\nFallo al comprobar satelites:\n", true,
				centroEspacial1.comprobarSatelites());
	}

	/** Prueba comprobar satélites (no hay vector de satélites) */
	@Test
	public void testComprobarSatelites2() {
		CentroEspacial centroEspacial2 = new CentroEspacial(
				"Observatorio Montana Cabreja", null);
		assertEquals("\nFallo al comprobar satelites:\n", false,
				centroEspacial2.comprobarSatelites());
	}

	/** Prueba comprobar satélites (vector de satélites vacío) */
	@Test
	public void testComprobarSatelites3() {
		CentroEspacial centroEspacial2 = new CentroEspacial(
				"Observatorio Montana Cabreja", new SateliteArtificial[0]);
		assertEquals("\nFallo al comprobar satelites:\n", false,
				centroEspacial2.comprobarSatelites());
	}

	/** Prueba comprobar satélites (satélites repetidos) */
	@Test
	public void testComprobarSatelites4() {
		SateliteArtificial[] satelites2 = new SateliteArtificial[5];
		satelites2[0] = new SateliteArtificial(new Estrella("Sol", 23.3, 19));
		satelites2[1] = new SateliteArtificial(new Estrella("Rigel", 3.3, 319));
		satelites2[2] = new SateliteArtificial(new Estrella("Epsilon Indi",
				213.3, 222));
		satelites2[3] = new SateliteArtificial(new Estrella("Alpha Centauri",
				111111.1, 35));
		satelites2[4] = new SateliteArtificial(new Estrella("Sol", 23.3, 19));
		CentroEspacial centroEspacial2 = new CentroEspacial(
				"Observatorio Montana Cabreja", satelites2);
		assertEquals("\nFallo al comprobar satelites:\n", false,
				centroEspacial2.comprobarSatelites());
	}

	/** Prueba comprobar satélites (satélites repetidos) */
	@Test
	public void testComprobarSatelites5() {
		SateliteArtificial[] satelites2 = new SateliteArtificial[5];
		satelites2[0] = new SateliteArtificial(new Estrella("Rigel", 3.3, 319));
		satelites2[1] = new SateliteArtificial(new Estrella("Epsilon Indi",
				213.3, 222));
		satelites2[2] = new SateliteArtificial(new Estrella("Alpha Centauri",
				111111.1, 35));
		satelites2[3] = new SateliteArtificial(new Estrella("Sol", 23.4, 19));
		satelites2[4] = new SateliteArtificial(new Estrella("Sol", 23.3, 19));
		CentroEspacial centroEspacial2 = new CentroEspacial(
				"Observatorio Montana Cabreja", satelites2);
		assertEquals("\nFallo al comprobar satelites:\n", false,
				centroEspacial2.comprobarSatelites());
	}

}
