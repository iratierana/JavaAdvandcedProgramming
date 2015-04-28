package mouseListenerBallMovement;

import java.awt.Color;

public class Ball {

	int height;
	int width;
	int posX;
	int posY;
	Color color;
	
	
	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
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


	public Ball(int height, int width, int posX, int posY) {
		super();
		this.height = height;
		this.width = width;
		this.posX = posX;
		this.posY = posY;
	}

	
}
