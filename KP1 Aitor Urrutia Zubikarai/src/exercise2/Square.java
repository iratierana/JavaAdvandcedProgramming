package exercise2;

public class Square extends Figure {
	int side;
	
	public Square(int posX, int posY, int side){
		super(posX,posY);
		this.side = side;
	}
	
	public void area(){
		super.area = side * side;
	}
	
	public String toString(){
		return "Square:" +
				super.toString() +
				"\nSide: " + side +
				"\n-.-.-.-.-.-.-.-";
	}
	
}
