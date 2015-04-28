package exercise2;

import java.util.Random;

public class Weapon implements Artefact {

	String name;
	int damage;
	
	public Weapon(String name, int damage) {
		super();
		this.name = name;
		this.damage = damage;
	}

	@Override
	public int attack() {
		Random generator = new Random();
		return generator.nextInt(10);
	}
	
	public String toString(){
		return "Weapon -> " + name + ": " + damage;
	}

}
