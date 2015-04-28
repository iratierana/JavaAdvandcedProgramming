package player;

import java.awt.Color;
import java.util.ArrayList;
import java.util.ListIterator;

import objects.Obstacle;
import main.ObstacleDetect;

public class CirclePlayer {

	String name;
	public Color color;
	public int posX;
	public int posY;
	public float speedX = 10;
	public float speedY = 10;
	public int radio;
	ListIterator<Obstacle> obstaclesListIt;
	ObstacleDetect obstacleDetector;
	
	public CirclePlayer(String name, int posX, int posY, int radio){
		this.name = name;
		this.color = Color.yellow;
		this.posX = posX;
		this.posY = posY;
		this.radio = radio;
		obstacleDetector = new ObstacleDetect();
	}
	
	public void phisics(int width, int height, ArrayList<Obstacle> obstaclesList){
		detectColisionWithLateral(width, obstaclesList);
		detectColisionWithObstacles(obstaclesList);
		gravity(height, obstaclesList);
		normal(height, obstaclesList);
		airFriction();
		floorFriction(height);
		posX = posX + (int)speedX;
		posY = posY + (int)speedY;
	}

	private void floorFriction(int height) {
		if((posY + 2*radio) >= height){
			if(speedX>0){
				speedX = (float) (speedX - 0.05*speedX);
			}
			if(speedX<0){
				speedX = (float) (speedX + 0.05*(-speedX));
			}
		}
		
	}

	private void airFriction() {
		if(speedX>0){
			speedX = (float) (speedX - 0.01*speedX);
		}
		if(speedX<0){
			speedX = (float) (speedX + 0.01*speedX);
		}
		
	}

	public void detectColisionWithLateral(int width, ArrayList<Obstacle> obstaclesList) {	
		
		
		if (speedX < 0 && posX <= 0 || speedX > 0 && posX + 2*radio >= width){
            speedX = -speedX;
		}

	}

	public boolean detectColisionWithFloor(int height){
		if((posY + 2*radio)>=height){
			return true;
		}
		return false;
	}
	
	public void detectColisionWithObstacles(ArrayList<Obstacle> obstaclesList) {
		obstaclesListIt = obstaclesList.listIterator();
		Obstacle obstacle;
		while(obstaclesListIt.hasNext()){
			obstacle = obstaclesListIt.next();
			
			
			
			while(this.obstacleDetector.northColision(this, obstacle)){
				if(speedY<0){
					speedY = -speedY;
					speedY = speedY - 1;
				}
				posY = posY - 1;	
			}
			while(this.obstacleDetector.southColision(this, obstacle)){
				if(speedY>0){
					speedY = -speedY;
					speedY = speedY + 1;
				}
				posY = posY + 1;	
			}
			while(this.obstacleDetector.westColision(this, obstacle)){
				if(speedX<0){
					speedX = -speedX;
					speedX = speedX - 1;
				}
				//posX = posX + 1;	
			}
			while(this.obstacleDetector.eastColision(this, obstacle)){
				if(speedX>0){
					speedX = -speedX;
					speedX = speedX + 1;
				}
				posX = posX - 1;	
			}
			while(this.obstacleDetector.northEastColision(this, obstacle)){
				if(speedX>0){
					speedX = -speedX;
					speedX = speedX + 1;
				}
				if(speedY<0){
					speedY = -speedY;
					speedY = speedY - 1;
				}
				posX = posX - 1;
				posY = posY + 1;
			}
			while(this.obstacleDetector.northWestColision(this, obstacle)){
				if(speedX<0){
					speedX = -speedX;
					speedX = speedX - 1;
				}
				if(speedY<0){
					speedY = -speedY;
					speedY = speedY - 1;
				}
				posX = posX + 1;
				posY = posY + 1;
			}
			while(this.obstacleDetector.southWestColision(this, obstacle)){
				if(speedX<0){
					speedX = -speedX;
					speedX = speedX - 1;
				}
				if(speedY>0){
					speedY = -speedY;
					speedY = speedY + 1;
				}
				posX = posX + 1;
				posY = posY - 1;
			}
			while(this.obstacleDetector.southEastColision(this, obstacle)){
				if(speedX>0){
					speedX = -speedX;
					speedX = speedX + 1;
				}
				if(speedY>0){
					speedY = -speedY;
					speedY = speedY + 1;
				}
				posX = posX - 1;
				posY = posY - 1;
			}
				
			/*	
			
			if(this.obstacleDetector.northColision(this, obstacle)){
				speedY = -speedY;
				speedY = speedY - 3;
			}
			if(this.obstacleDetector.southColision(this, obstacle)){
				speedY = -speedY;
				speedY = speedY + 3;
			}
			if(this.obstacleDetector.westColision(this, obstacle)){
				speedX = -speedX;
				speedX = speedX - 3;
			}
			if(this.obstacleDetector.eastColision(this, obstacle)){
				speedX = -speedX;
				speedX = speedX + 3;
			}
			if(this.obstacleDetector.northEastColision(this, obstacle)){
				speedX = -speedX;
				speedY = -speedY;
				speedX = speedX + 3;
				speedY = speedY - 3;
			}
			if(this.obstacleDetector.northWestColision(this, obstacle)){
				speedX = -speedX;
				speedY = -speedY;
				speedX = speedX - 3;
				speedY = speedY - 3;
			}
			if(this.obstacleDetector.southWestColision(this, obstacle)){
				speedX = -speedX;
				speedY = -speedY;
				speedX = speedX - 3;
				speedY = speedY + 3;
			}
			if(this.obstacleDetector.southEastColision(this, obstacle)){
				speedX = -speedX;
				speedY = -speedY;
				speedX = speedX + 3;
				speedY = speedY + 3;
			}
			
			*/
			
			/*
			
			//GENERAL
			if(((this.posX + 2*radio) >= (obstacle.posX)) && ((this.posX) <= ((obstacle.posX + obstacle.width)))){
				if(((this.posY + 2*radio) >= (obstacle.posY)) && ((this.posY) <= ((obstacle.posY + obstacle.height)))){
					
				}
			}
			
			//NORTH
			if(((this.posX+radio) <= (obstacle.posX + obstacle.width))&&((this.posX+radio) >= (obstacle.posX))){
				if(((this.posY) <= (obstacle.posY + obstacle.height))&&((this.posY) >= (obstacle.posY))){
					speedY = -speedY;
					speedY = speedY - 1;
				}
			}
			
			//SOUTH
			if(((this.posX+radio) <= (obstacle.posX + obstacle.width))&&((this.posX+radio) >= (obstacle.posX))){
				if(((this.posY+ 2*radio) <= (obstacle.posY + obstacle.height))&&((this.posY+ 2*radio) >= (obstacle.posY))){
					speedY = -speedY;
					speedY = speedY + 3;
				}
			}
			
			//WEST
			if(((this.posX) <= (obstacle.posX + obstacle.width))&&((this.posX) >= (obstacle.posX))){
				if(((this.posY+ radio) <= (obstacle.posY + obstacle.height))&&((this.posY+ radio) >= (obstacle.posY))){
					speedX = -speedX;
					speedX = speedX - 3;
				}
			}
			
			//EAST
			if(((this.posX + 2*radio) <= (obstacle.posX + obstacle.width))&&((this.posX + 2*radio) >= (obstacle.posX))){
				if(((this.posY+ radio) <= (obstacle.posY + obstacle.height))&&((this.posY+ radio) >= (obstacle.posY))){
					speedX = -speedX;
					speedX = speedX + 3;
				}
			}
			
			//NORTH-EAST
			if(((this.posX + radio) < (obstacle.posX + obstacle.width))&&((this.posX + 2*radio) > (obstacle.posX))){
				if(((this.posY) < (obstacle.posY + obstacle.height))&&((this.posY + radio) > (obstacle.posY))){
					speedX = -speedX;
					speedY = -speedY;
					speedX = speedX + 3;
					speedY = speedY - 3;
				}
			}
			
			//NORTH-WEAST
			if(((this.posX) < (obstacle.posX + obstacle.width))&&((this.posX + radio) > (obstacle.posX))){
				if(((this.posY) < (obstacle.posY + obstacle.height))&&((this.posY + radio) > (obstacle.posY))){
					speedX = -speedX;
					speedY = -speedY;
					speedX = speedX - 3;
					speedY = speedY - 3;
				}
			}
			
			//SOUTH-WEAST
			if(((this.posX) < (obstacle.posX + obstacle.width))&&((this.posX + radio) > (obstacle.posX))){
				if(((this.posY + radio) < (obstacle.posY + obstacle.height))&&((this.posY + 2*radio) > (obstacle.posY))){
					speedX = -speedX;
					speedY = -speedY;
					speedX = speedX - 3;
					speedY = speedY + 3;
				}
			}
			
			//SOUTH-EAST
			if(((this.posX + radio) < (obstacle.posX + obstacle.width))&&((this.posX + 2*radio) > (obstacle.posX))){
				if(((this.posY + radio) < (obstacle.posY + obstacle.height))&&((this.posY + 2*radio) > (obstacle.posY))){
					speedX = -speedX;
					speedY = -speedY;
					speedX = speedX + 3;
					speedY = speedY + 3;
				}
			}
			*/
			
		}
	}
	
	public boolean detectColisionWithObstaclesSouth(ArrayList<Obstacle> obstaclesList) {
		obstaclesListIt = obstaclesList.listIterator();
		Obstacle obstacle;
		while(obstaclesListIt.hasNext()){
			obstacle = obstaclesListIt.next();
			if(obstacleDetector.southColision(this, obstacle)){
				return true;
			}
		}
		return false;
	}
	
	public boolean detectColisionWithObstaclesHorizontal(ArrayList<Obstacle> obstaclesList){
		obstaclesListIt = obstaclesList.listIterator();
		Obstacle obstacle;
		while(obstaclesListIt.hasNext()){
			obstacle = obstaclesListIt.next();
			if(((this.posX + 2*radio) >= (obstacle.posX)) && ((this.posX) <= ((obstacle.posX + obstacle.width)))){
				return true;
			}
		}
		return false;
	}
	
	public void gravity(int height, ArrayList<Obstacle> obstaclesList){
		if((!detectColisionWithFloor(height))&&(!detectColisionWithObstaclesSouth(obstaclesList))){
			speedY = (float) (speedY + 1);
		}
	}

	public void normal(int height, ArrayList<Obstacle> obstaclesList){
		if((detectColisionWithFloor(height))||(detectColisionWithObstaclesSouth(obstaclesList))){
			if(speedY>5){
				speedY = - speedY;
				speedY = (float) (speedY + 5);
			}
			if(speedY>2.5){
				speedY = - speedY;
				speedY = (float) (speedY + 2.5);
			}
			if(speedY>1){
				speedY = - speedY;
				speedY = (float) (speedY + 1);
			}
		}
	}
	
}
