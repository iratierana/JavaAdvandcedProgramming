package exercise2;

public class Triangle extends Figure {
	int base;
	int height;
	
	public Triangle(int posX, int posY, int base, int height){
		super(posX,posY);
		this.base = base;
		this.height = height;
	}
	
	public void area(){
		super.area = (base * height)/2;
	}
	
	public String toString(){
		return "Triangle:" +
				super.toString() +
				"\nBase: " + base +
				"\nHeight: " + height +
				"\n-.-.-.-.-.-.-.-";
	}
}
