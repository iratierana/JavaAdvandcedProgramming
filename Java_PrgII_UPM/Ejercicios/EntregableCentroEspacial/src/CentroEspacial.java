import anotacion.*; //Importa las anotaciones definidas para programación2

@Programacion2(
)
public class CentroEspacial {

	private String identificador;
	private SateliteArtificial[] satelitesSupervisados;

	public CentroEspacial(String identificador,
			SateliteArtificial[] satelitesSupervisados) {
		this.identificador = identificador;
		this.satelitesSupervisados = satelitesSupervisados;
	}

	/**
	 * @return el identificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	public String informacionEstrellas() {
		String resultado = "";
		for (int i = 0; i < this.satelitesSupervisados.length; i++) {
			if (!this.satelitesSupervisados[i].hayAlertaTormentaMagnetica())
				resultado = resultado
						+ this.satelitesSupervisados[i].getEstrella()
								.getIdentificador() + " " + "("
						+ this.satelitesSupervisados[i].darTemperatura() + ")"
						+ "\n";
			else
				resultado = resultado
						+ this.satelitesSupervisados[i].getEstrella()
								.getIdentificador() + " " + "("
						+ this.satelitesSupervisados[i].darTemperatura() + ")"
						+ " " + "ALERTA!" + "\n";
		}
		return resultado;
	}

	public boolean comprobarSatelites() {
		// Hay al menos uno
		if (this.satelitesSupervisados == null)
			return false;
		int supervisados = 0;
		for (int i = 0; i < this.satelitesSupervisados.length; i++) {
			if (this.satelitesSupervisados[i] != null)
				supervisados++;
		}

		if (supervisados == 0)
			return false;
		// No hay ninguno igual
		else {
			boolean resultado = false;
			for (int i = 0; i < satelitesSupervisados.length && !resultado; i++) {
				for (int j = i + 1; j < satelitesSupervisados.length
						&& !resultado; j++) {
					resultado = satelitesSupervisados[i]
							.equals(satelitesSupervisados[j]);
				}
			}
			return !resultado;
		}
	}

	// TODO

}
