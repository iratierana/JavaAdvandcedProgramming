package exercise2;

public class Figure {
	int posX, posY;
	int area;
	
	public Figure(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}
	
	public String toString(){
		return "\nPosition X: " + posX +
				"\nPosition Y: " + posY +
				"\nArea: " + area;
	}
}
