package exercise2;

import java.util.Random;

public class Potion implements Artefact{

	String name;
	int cuality;
	
	public Potion(String name, int cuality) {
		super();
		this.name = name;
		this.cuality = cuality;
	}
	
	public String toString(){
		return "Potion -> " + name + ": " + cuality;
	}

	@Override
	public int attack() {
		Random generator = new Random();
		return generator.nextInt(10);
	}
	
}
