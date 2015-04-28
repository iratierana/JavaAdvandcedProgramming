package objects;

import java.awt.Color;
import java.util.ArrayList;
import java.util.ListIterator;

public class Object {
	
	public Color color = null;
	public int posX = 0, posY = 0;
	public float speedX = 0, speedY = 0;
	public int width = 0, height = 0; 
	public int weight = 0;
	
	ListIterator objectsListIt;
	
	
	
	public Object(Color color, int posX, int posY, int width, int height, int weight) {
		this.color = color;
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.weight = weight;
	}

	public void phisics(int width, int height, ArrayList <Object> objectsList){
		detectColisionWithLateral(width);
		gravity(height);
		normal(height);
		airFriction();
		floorFriction(height);
		colisionsWithObjects(objectsList);
		stopMovement();
		posX = posX + (int)speedX;
		posY = posY + (int)speedY;
	}

	private void stopMovement() {
		if((speedX<1)&&(speedX>-1)){
			speedX = 0;
		}
		if((speedY<1)&&(speedY>-1)){
			speedY = 0;
		}
	}

	public void colisionsWithObjects(ArrayList <Object> objectsList) {
		objectsListIt = objectsList.listIterator();
		
		while(objectsListIt.hasNext()){
			Object auxObject = (Object) objectsListIt.next();
			
			if(auxObject != this){
				if(northColision(this, auxObject)){
					if(speedY<0){
						speedY = (float) (- 0.75*speedY);
					}
				}
				if(southColision(this, auxObject)){
					if(speedY>0){
						speedY = (float) (- 0.75*speedY);
					}
				}
				if(westColision(this, auxObject)){
					if(speedX<0){
						//speedX = (float) (- 0.75*speedX);
					}
				}
				if(eastColision(this, auxObject)){
					if(speedX>0){
						//speedX = (float) (- 0.75*speedX);
					}
				}
			}
		}
		
	}

	public void floorFriction(int height) {
		if((posY + this.height) >= height){
			if(speedX>0){
				speedX = (float) (speedX - 0.5*this.weight);
			}
			if(speedX<0){
				speedX = (float) (speedX + 0.5*this.weight);
			}
		}
		
	}

	public void airFriction() {
		if(speedX>0){
			speedX = (float) (speedX - 0.15*this.weight);
		}
		if(speedX<0){
			speedX = (float) (speedX + 0.15*this.weight);
		}
		
	}

	public void detectColisionWithLateral(int width) {	
		
		
		if (speedX < 0 && posX <= 0 || speedX > 0 && posX + this.width >= width)
            speedX = -speedX;

		
	}
	
	public void gravity(int height){
		if((posY + this.height)<height){
			speedY = speedY + this.weight;
		}
	}
	
	public void normal(int height){
		if((posY + this.height)>=height){
			if(speedY>0){
				speedY = - speedY;
				speedY = speedY + 5*this.weight;
			}
		}
	}
	
	public boolean northColision(Object o1, Object o2){
		//NORTH		
		if(((o1.posX + o1.width) >= (o2.posX))&&((o1.posX) <= (o2.posX + o2.width))){
			if(((o1.posY) <= (o2.posY + o2.height))&&((o1.posY) >= (o2.posY))){
				return true;
			}
		}
		return false;
	}
	
	public boolean southColision(Object o1, Object o2){
		//SOUTH
		if(((o1.posX + o1.width) >= (o2.posX))&&((o1.posX) <= (o2.posX + o2.width))){
			if(((o1.posY + o1.height) >= (o2.posY))&&((o1.posY + o1.height) <= (o2.posY + o2.height))){
				return true;
			}
		}
		return false;
	}

	public boolean westColision(Object o1, Object o2){
		//WEST
		if(((o1.posX) <= (o2.posX + o2.width))&&((o1.posX) >= (o2.posX))){
			if(((o1.posY + o1.height) >= (o2.posY))&&((o1.posY) <= (o2.posY + o2.height))){
				return true;
			}
		}
		return false;
	}

	public boolean eastColision(Object o1, Object o2){
		//EAST
		if(((o1.posX + o1.width) >= (o2.posX))&&((o1.posX + o1.width) <= (o2.posX + o2.width))){
			if(((o1.posY + o1.height) >= (o2.posY))&&((o1.posY) <= (o2.posY + o2.height))){
				return true;
			}
		}
		return false;
	}
}
