package exercise1;

public class Signature {
	String name;
	String mark;
	
	public Signature(String[] split) {
		name = split[0];
		mark = split[1];
	}

	public String toString(){
		return name + ": " + mark;
	}
}
