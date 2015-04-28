package lokalZentsoa;

import java.io.Serializable;
import java.util.ArrayList;

public class Lokala implements Serializable {

	String jabea;
	String helbidea;
	int metroKarratuak;
	ArrayList<String> instalakuntzaBereziakList;
	ArrayList<Pertsona> pertsonaList;
	
	public Lokala(){
		instalakuntzaBereziakList = new ArrayList<String>();
		pertsonaList = new ArrayList<Pertsona>();
	}
	
	public String getJabea() {
		return jabea;
	}
	
	public void setJabea(String jabea) {
		this.jabea = jabea;
	}
	
	public String getHelbidea() {
		return helbidea;
	}
	
	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}
	
	public int getMetroKarratuak() {
		return metroKarratuak;
	}
	
	public void setMetroKarratuak(int metroKarratuak) {
		this.metroKarratuak = metroKarratuak;
	}
	
	public ArrayList<String> getInstalakuntzaBereziakList() {
		return instalakuntzaBereziakList;
	}
	
	public void setInstalakuntzaBereziakList(
			ArrayList<String> instalakuntzaBereziakList) {
		this.instalakuntzaBereziakList = instalakuntzaBereziakList;
	}
	
	public ArrayList<Pertsona> getPertsonaList() {
		return pertsonaList;
	}
	
	public void setPertsonaList(ArrayList<Pertsona> pertsonaList) {
		this.pertsonaList = pertsonaList;
	}

	@Override
	public String toString() {
		return "Lokala [jabea=" + jabea + ", helbidea=" + helbidea
				+ ", metroKarratuak=" + metroKarratuak
				+ ", instalakuntzaBereziakList=" + instalakuntzaBereziakList
				+ ", pertsonaList=" + pertsonaList + "]";
	}
	
}
