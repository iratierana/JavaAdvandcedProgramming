package exercise2;

public class Circle extends Figure {
	int radio;
	
	public Circle(int posX, int posY, int radio){
		super(posX,posY);
		this.radio = radio;
	}
	
	public void area(){
		super.area = (int) (3.1416 * radio * radio);
	}
	
	public String toString(){
		return "Circle:" +
				super.toString() +
				"\nRadio: " + radio +
				"\n-.-.-.-.-.-.-.-";
	}
}
