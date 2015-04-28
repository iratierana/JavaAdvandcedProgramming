import anotacion.*; //Importa las anotaciones definidas para programación2
@Programacion2 (
		)
public class SateliteArtificial {
	
	private String identificador ;
	private static int ordenCreacion = 1;
	private Estrella estrellaMonitorizada;
	
	public SateliteArtificial (Estrella estrellaMonitorizada) {
		this.estrellaMonitorizada = estrellaMonitorizada;
		this.identificador = "Sat" + (SateliteArtificial.ordenCreacion++);
		
		
	}

	/**
	 * @return la estrella Monitorizada
	 */
	public Estrella getEstrella() {
		return estrellaMonitorizada;
	}

	/**
	 * @param estrellaMonitorizada La estrella monitorizada a cambiar
	 */
	public void setEstrella(Estrella estrellaMonitorizada) {
		this.estrellaMonitorizada = estrellaMonitorizada;
	}

	/**
	 * @return el identificador
	 */
	public  String getIdentificador() {
		return identificador;
	}
	
	public double darTemperatura() {
		return this.estrellaMonitorizada.getIndiceColor() * 2.1;
	}
	
	public boolean hayAlertaTormentaMagnetica () {
		return this.estrellaMonitorizada.getCampoMagnetico() >= 1000;
	}
	
	public boolean equals (SateliteArtificial sat) {
		return this.estrellaMonitorizada.equals(sat.estrellaMonitorizada);
	}
	
	
	
	
//TODO
}
