package main;

import java.sql.Date;
import java.util.Random;

import dataBase.DatosVaca;

public class Loop {

	Date date;
	
	public Loop(Date date) {
		super();
		this.date = date;
		makeInsert();
	}
	private void makeInsert() {
		Random generator = new Random();
		int sensorID = 0;
		int vacaID = 0;
		for(int i = 1; i < 11; i++) {
			DatosVaca dLat = new DatosVaca(((i - 1)*3) + 1, i, date, (float)(43.0833 + (generator.nextDouble()/100)), 4);
			dLat.introducirEnBD();
			DatosVaca dLong = new DatosVaca(((i - 1)*3) + 2, i, date, (float)(-2.1167 + (generator.nextDouble()/100)), 3);
			dLong.introducirEnBD();
		}
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
