package exercise2;

public class Circle extends Figure{

	float radio;

	public Circle(float area, int posX, int posY, float radio) {
		super(area, posX, posY);
		this.radio = radio;
	}

	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}
	
	
}
