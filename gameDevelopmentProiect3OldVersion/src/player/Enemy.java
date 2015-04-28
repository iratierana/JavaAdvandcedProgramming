package player;

import java.awt.Color;

import objects.Object;

public class Enemy {

	final int WINDOWWIDTH = 640;
	final int WINDOWHEIGHT = 480;
	final int GAMEZONEWIDTH = WINDOWWIDTH + 1000;
	final int GAMEZONEHEIGHT = WINDOWHEIGHT + 1000;
	
	int posX, posY;
	int radio;
	int weight;
	Color color;
	
	public Enemy(int posX, int posY, int radio, int weight, Color color) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.radio = radio;
		this.weight = weight;
		this.color = color;
	}
	
	public void movements(Player player){
		
		if(player.getPosX() - posX < 0) posX = posX - weight;
		if(player.getPosX() - posX > 0) posX = posX + weight;
		
		if(player.getPosY() - posY < 0) posY = posY - weight;
		if(player.getPosY() - posY > 0) posY = posY + weight;
		
		if(player.distanceTo(this) < weight){
			this.posX = player.getPosX();
			this.posY = player.getPosY();
		}
		

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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	public void addWeight(int i) {
		this.weight++;
		
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
