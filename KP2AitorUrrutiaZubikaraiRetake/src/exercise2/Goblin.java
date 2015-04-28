package exercise2;

public class Goblin extends Criature{

	final int hability = 50;
	
	public Goblin(String name, Artefact artefact) {
		super(100, name, artefact);
	}
	
	public String toString() {
		return super.toString() + "Goblin [hability=" + hability + "]";
	}
}
