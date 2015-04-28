package exercise2;

public class Elf extends Criature{

	final int hability = 100;
	
	public Elf(String name, Artefact artefact) {
		super(50, name, artefact);
	}

	@Override
	public String toString() {
		return super.toString() + "Elf [hability=" + hability + "]";
	}

	
	
}
