package exercise2;

import java.util.Random;

public class Poison implements Artefact {

	String name;
	int power;
	
	public Poison(String name, int power) {
		super();
		this.name = name;
		this.power = power;
	}

	@Override
	public int attack() {
		Random generator = new Random();
		return generator.nextInt(10);
	}
	
	public String toString(){
		return "Poison -> " + name + ": " + power;
	}
	
}
