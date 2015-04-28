package lokalZentsoa;

import java.io.Serializable;

public class Pertsona implements Serializable {

	String nan;
	String izena;
	String abizena;
	
	public String getNan() {
		return nan;
	}
	public void setNan(String nan) {
		this.nan = nan;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getAbizena() {
		return abizena;
	}
	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}
	
	@Override
	public String toString() {
		return "Pertsona [nan=" + nan + ", izena=" + izena + ", abizena="
				+ abizena + "]";
	}
	
	
}
