package exercise2;

public class Rectangle extends Figure {
	int side1;
	int side2;
	
	public Rectangle(int posX, int posY, int side1, int side2){
		super(posX,posY);
		this.side1 = side1;
		this.side2 = side2;
	}
	
	public void area(){
		super.area = side1 * side2;
	}
	
	public String toString(){
		return "Rectangle:" +
				super.toString() +
				"\nSide 1: " + side1 +
				"\nSide 2: " + side2 +
				"\n-.-.-.-.-.-.-.-";
	}
}
