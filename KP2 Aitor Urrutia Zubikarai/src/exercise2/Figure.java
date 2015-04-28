package exercise2;

public class Figure {
	float area;
	int posX;
	int posY;
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public Figure(float area, int posX, int posY) {
		this.area = area;
		this.posX = posX;
		this.posY = posY;
	}
	
	
}
