package exercise1;

public class Coin {
	String name;
	float value;
	
	public Coin (String name, float value){
		this.name = name;
		this.value = value;
	}
	
	public float change(float origin, float value){
		float destination = 0;
		destination = (origin/this.value)*value;
		return destination;
	}
	
	public String toString(){
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
}
