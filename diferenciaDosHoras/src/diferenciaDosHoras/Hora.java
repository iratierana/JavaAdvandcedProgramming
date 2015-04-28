package diferenciaDosHoras;

public class Hora {

	int minutos = 0;
	public Hora (int minutos){
		this.minutos= minutos;
	}
	public int diferencia(int minutos){
		
		int diferencia = 0;
		
		if(this.minutos > minutos){
			diferencia = this.minutos - minutos;
		}
		if(this.minutos < minutos){
			diferencia = minutos - this.minutos;
		}
		if(this.minutos == minutos){
			diferencia = 0;
		}
		
		return diferencia;
	}
	
	public void recogerMinutos(int minutos){
		this.minutos = minutos;
	}
	
}
