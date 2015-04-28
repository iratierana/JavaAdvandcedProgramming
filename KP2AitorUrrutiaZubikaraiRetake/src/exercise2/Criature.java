package exercise2;

import java.util.ArrayList;

public class Criature {

	int live;
	String name;
	Artefact artefact;
	String health;
	
	public Criature(int live, String name, Artefact artefact) {
		super();
		this.live = live;
		this.name = name;
		this.artefact = artefact;
		health = "Healthy";
	}

	@Override
	public String toString() {
		return "Criature [live=" + live + ", name=" + name + ", artefact="
				+ artefact + ", health=" + health + "]";
	}
	
}
