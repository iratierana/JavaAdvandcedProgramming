package exercise2;

public class Square extends Figure{
	
	float side1;
	float side2;
	
	public float getSide1() {
		return side1;
	}

	public void setSide1(float side1) {
		this.side1 = side1;
	}

	public float getSide2() {
		return side2;
	}

	public void setSide2(float side2) {
		this.side2 = side2;
	}

	public Square(float area, int posX, int posY, float side1, float side2) {
		super(area, posX, posY);
		this.side1 = side1;
		this.side2 = side2;
	}

	
	
}
