package player;

import java.awt.Color;

import objects.Object;
import movements.Colision;

public class Player{

	final int WINDOWWIDTH = 640;
	final int WINDOWHEIGHT = 480;
	final int GAMEZONEWIDTH = WINDOWWIDTH + 1000;
	final int GAMEZONEHEIGHT = WINDOWHEIGHT + 1000;
	
	int posX, posY;
	int radio;
	int weight;
	double strengthXPositive = 0, strengthXNegative = 0, strengthYPositive = 0, strengthYNegative = 0;
	Color color;
	
	public Player(int posX, int posY, int radio, int weight, Color color) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.radio = radio;
		this.weight = weight;
		this.color = color;
	}
	
	public void strengthToMovements(){
		
		int strengthX = (int) (strengthXPositive - strengthXNegative);
		int strengthY = (int) (strengthYPositive - strengthYNegative);
		
		posX = posX + (strengthX / weight);
		posY = posY + (strengthY / weight);
		
		if(posX - radio < 0) posX = radio;
		if(posX + radio >= GAMEZONEWIDTH) posX = GAMEZONEWIDTH - 1 - radio;
		
		if(posY - radio < 0) posY = radio;
		if(posY + radio >= GAMEZONEHEIGHT) posY = GAMEZONEHEIGHT - 1 - radio;

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
	public int getRadio() {
		return radio;
	}
	public void setRadio(int radio) {
		this.radio = radio;
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
	public boolean checkPosition(Enemy enemy) {
		if(this.posX == enemy.getPosX()) if(this.posY == enemy.getPosY()) return true;
		return false;
	}
	public double distanceTo(Enemy enemy) {
		return Math.sqrt((Math.pow((this.posX - enemy.getPosX()), 2))+(Math.pow((this.posY - enemy.getPosY()), 2)));
	}
	
	public boolean checkColision(Object object){
		boolean movement = false;
		
		if(posX + radio < object.getPosX()){
			return false;
		}
		if(object.getPosX() + object.getHeight() < posX - radio){
			return false;
		}
		
		if(posY + radio < object.getPosY()){
			return false;
		}
		if(object.getPosY() + object.getHeight() < posY - radio){
			return false;
		}
		
		//objetuaren ezkerreko talka
		if((posX + radio < object.getPosX() + (object.getWidth()/2))&&(posX + radio > object.getPosX())){
			posX =  object.getPosX() - radio - 1;
			return true;
		}
		
		//objetuaren eskumako talka
		if((posX - radio > object.getPosX() + (object.getWidth()/2))&&(posX - radio < object.getPosX() + object.getWidth())){
			posX = object.getPosX() + object.getWidth() + radio + 1;
			return true;
		}
		
		//objetuaren goiko talka
		if((posY + radio < object.getPosY() + (object.getHeight()/2))&&(posY + radio > object.getPosY())){
			posY = object.getPosY() - radio - 1;
			return true;
		}
		
		//objetuaren beheko talka
		if((posY - radio > object.getPosY() + (object.getHeight()/2))&&(posY - radio < object.getPosY() + object.getHeight())){
			posY = object.getPosY() + object.getHeight() + radio + 1;
			return true;
		}
		
		return true;
		
	}

}
