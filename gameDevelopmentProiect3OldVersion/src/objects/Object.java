package objects;

import java.awt.Color;

public abstract class Object {
	
	int posX, posY;
	int width, height;
	int weight;
	double strengthXPositive, strengthXNegative, strengthYPositive, strengthYNegative;
	Color color;
	
	
	
	public Object(int posX, int posY, int width, int height, int weight,
			Color color) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.color = color;
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
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public double getStrengthXPositive() {
		return strengthXPositive;
	}
	public void setStrengthXPositive(double strengthXPositive) {
		this.strengthXPositive = strengthXPositive;
	}
	public double getStrengthXNegative() {
		return strengthXNegative;
	}
	public void setStrengthXNegative(double strengthXNegative) {
		this.strengthXNegative = strengthXNegative;
	}
	public double getStrengthYPositive() {
		return strengthYPositive;
	}
	public void setStrengthYPositive(double strengthYPositive) {
		this.strengthYPositive = strengthYPositive;
	}
	public double getStrengthYNegative() {
		return strengthYNegative;
	}
	public void setStrengthYNegative(double strengthYNegative) {
		this.strengthYNegative = strengthYNegative;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
}
